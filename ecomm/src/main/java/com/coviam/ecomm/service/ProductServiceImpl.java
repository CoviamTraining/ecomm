package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.*;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by gaurav on 03/06/17.
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public ProductOnDetailPage getProduct(int id) {
        Product product = productRepository.findOne(id);

        ProductOnDetailPage productOnDetailPage = new ProductOnDetailPage();

        productOnDetailPage.setProductid(product.getProductid());
        productOnDetailPage.setName(product.getName());
        productOnDetailPage.setAttributes(product.getAttributes());
        productOnDetailPage.setBrand(product.getBrand());
        productOnDetailPage.setDescription(product.getDescription());
        productOnDetailPage.setImageurl(product.getImageurl());
        productOnDetailPage.setRating(product.getRating());
        productOnDetailPage.setUsp(product.getUsp());

        List<String> merchants = Arrays.asList(product.getMerchantlist().split(","));
        String merchantUri = "http://172.16.20.10:8090/getMerchantNameLogoRating/";
        String priceUri = "http://172.16.20.13:8090/getprice/";
        ArrayList<OtherMerchantToOffer> otherMerchantToOffers = new ArrayList<>();
        for(String merchant : merchants){
            MerchantInfoNameLogoRating merchantInfoNameLogoRating = restTemplate.getForObject(merchantUri+merchant,
                    MerchantInfoNameLogoRating.class);

            OtherMerchantToOffer otherMerchantToOffer = new OtherMerchantToOffer();

            otherMerchantToOffer.setName( merchantInfoNameLogoRating.getName() );
            otherMerchantToOffer.setRating( merchantInfoNameLogoRating.getRating() );
            otherMerchantToOffer.setImageurl( merchantInfoNameLogoRating.getLogo() );

            String price = restTemplate.getForObject(priceUri+product.getProductid()+"/"+merchant,String.class);
            otherMerchantToOffer.setPrice(Double.parseDouble(price));
            otherMerchantToOffers.add(otherMerchantToOffer);
        }
        productOnDetailPage.setOtherMerchantToOffer(otherMerchantToOffers);


        String productReviewUri = "http://172.16.20.13:8090/getproductfeedback/";
        ResponseEntity<List<ProductRatingReview>> responseEntity = restTemplate.exchange(productReviewUri + id, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ProductRatingReview>>() {});
        List<ProductRatingReview> productReviewsObject = responseEntity.getBody();
        List <ProductRatingReview> productRatingReviews = (List<ProductRatingReview>)(Object) productReviewsObject ;
        productOnDetailPage.setProductRatingReviews(productReviewsObject);

        return productOnDetailPage;
    }

    // TODO
    @Override
    public Product updatemerchantlist( int productId) {
        Product product = productRepository.findOne(productId);

        String merchantUri = "http://172.16.20.10:8090/getSoldAndDistinctProduct/";
        String stockUri = "http://172.16.20.13:8090/getstock/";
        String priceUri = "http://172.16.20.13:8090/getprice/";
        String avgRatingUri = "http://172.16.20.13:8090/getavgrating/";

        ArrayList<Pair<String , Double >> merchantScore = new ArrayList<>();
        List<String> merchantList = getMerchantList(product.getProductid());

        // number of distinct products merchant offer to sell and product sold
        for (String merchant : merchantList){
            MerchantInforSoldDistinctRating merchantInforSoldDistinct = restTemplate.getForObject(merchantUri+merchant,
                    MerchantInforSoldDistinctRating.class);

            int stock = restTemplate.getForObject(stockUri+product.getProductid()+"/"+merchant,Integer.class);
            int price = restTemplate.getForObject(priceUri+product.getProductid()+"/"+merchant,Integer.class);
            double avg_rating = restTemplate.getForObject(avgRatingUri+merchant,Double.class);

            double score = 0;
            if(stock == 0){
                score = -1000;
            }else{
                score = avg_rating + merchantInforSoldDistinct.getRating() + 100/price ;
            }

            merchantScore.add(new Pair<>(merchant,score));
        }


        Collections.sort(merchantScore, new Comparator<Pair<String, Double>>() {
            @Override
            public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {

                if (o1.getValue() > o2.getValue()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        merchantList.clear();
        for(Pair<String,Double> pair : merchantScore ){
            merchantList.add(pair.getKey());
        }
        product.setMerchantlist(String.join(",",merchantList));

        return productRepository.save(product);
    }


    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductInfoForList getProductNameImageRating(int id) {
        return productRepository.getproductNameImageRating(id);
    }

    @Override
    public List<String> getProductImages(int id) {
        String images = productRepository.getImages(id);
        return Arrays.asList(images.split(","));
    }

    @Override
    public List<String> getMerchantList(int id) {
        String merchants = productRepository.getMerchantList(id);
        List<String> merchantsList = Arrays.asList(merchants.split(","));
        return merchantsList;
    }

    @Override
    public String getDefaultMerchant(int id) {
        String merchants = productRepository.getMerchantList(id);
        List<String> merchantsList = Arrays.asList(merchants.split(","));
        return merchantsList.get(0);
    }

    @Override
    public List<ProductInfoToListUI> getProductByCategory(int categoryid) {
        List<ProductInfoForList> productInfoForList = productRepository.getByCategory(categoryid);

        List<ProductInfoToListUI> productInfoToUI = new ArrayList<>();

        for(ProductInfoForList productInfoForList1 : productInfoForList){
            ProductInfoToListUI productInfoToUITemp = new ProductInfoToListUI();

            productInfoToUITemp.setProductid(productInfoForList1.getProductid());
            productInfoToUITemp.setName(productInfoForList1.getName());
            productInfoToUITemp.setImageurl(productInfoForList1.getImageurl());
            productInfoToUITemp.setRating(productInfoForList1.getRating());

            String merchantId = getDefaultMerchant(productInfoForList1.getProductid());

            String merchantUri = "http://172.16.20.13:8090/getprice/"+productInfoForList1.getProductid()+"/"+
                    merchantId;

            String price = restTemplate.getForObject(merchantUri,String.class);

            productInfoToUITemp.setPrice(Double.parseDouble(price));

            productInfoToUI.add(productInfoToUITemp);
        }

        return productInfoToUI ;
    }

    @Override
    public String getProductImage(int id) {
        String images = productRepository.getImages(id);
        return Arrays.asList(images.split(",")).get(0);
    }

    @Override
    public List<Product> findByNameIgnoreCase(String name ){
        return productRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Product> findByNameContainingSubString(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }


}
