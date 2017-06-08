package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.*;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${inventoryUri}")
    String inventoryUri;

    @Value("${merchantUri}")
    String merchantUri;

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
        ArrayList<OtherMerchantToOffer> otherMerchantToOffers = new ArrayList<>();
        for(String merchant : merchants){
            MerchantInfoNameLogoRating merchantInfoNameLogoRating = restTemplate.getForObject(merchantUri+"getMerchantNameLogoRating/"
                            +merchant, MerchantInfoNameLogoRating.class);

            OtherMerchantToOffer otherMerchantToOffer = new OtherMerchantToOffer();

            otherMerchantToOffer.setName( merchantInfoNameLogoRating.getName() );
            otherMerchantToOffer.setMerchantId(Integer.parseInt(merchant));
            otherMerchantToOffer.setRating( merchantInfoNameLogoRating.getRating() );
            otherMerchantToOffer.setLogo( merchantInfoNameLogoRating.getLogo() );

            String price = restTemplate.getForObject(inventoryUri+"getprice/"+product.getProductid()+"/"+merchant,String.class);
            if (price == null){
                continue;
            }
            otherMerchantToOffer.setPrice(Double.parseDouble(price));

            otherMerchantToOffers.add(otherMerchantToOffer);
        }
        productOnDetailPage.setOtherMerchantToOffer(otherMerchantToOffers);

        ResponseEntity<List<ProductRatingReview>> responseEntity = restTemplate.exchange(inventoryUri+"getproductfeedback/"+ id+"/"+merchants.get(0), HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ProductRatingReview>>() {});
        List<ProductRatingReview> productReviewsList = responseEntity.getBody();
        productOnDetailPage.setProductRatingReviews(productReviewsList);

        return productOnDetailPage;
    }

    // TODO
    @Override
    public Product updatemerchantlist( int productId) {
        Product product = productRepository.findOne(productId);

        ArrayList<Pair<String , Double >> merchantScore = new ArrayList<>();
        List<String> merchantList = getMerchantList(product.getProductid());

        // number of distinct products merchant offer to sell and product sold
        for (String merchant : merchantList){
            MerchantInforSoldDistinctRating merchantInforSoldDistinctRating = restTemplate.getForObject(merchantUri+"getSoldAndDistinctProduct/"+merchant,
                    MerchantInforSoldDistinctRating.class);

            double stock = restTemplate.getForObject(inventoryUri+"getstock/"+product.getProductid()+"/"+merchant,Double.class);
            double price = restTemplate.getForObject(inventoryUri+"getprice/"+product.getProductid()+"/"+merchant,Double.class);
            double avg_rating = restTemplate.getForObject(inventoryUri+"getAvgRating/"+merchant+"/"+product.getProductid(),Double.class);

            double score = 0;
            if(stock == 0){
                score = -1000;
            }else{
                score = avg_rating + merchantInforSoldDistinctRating.getRating() + 100/price ;
            }

            merchantScore.add(new Pair<>(merchant,score));
        }


        Collections.sort(merchantScore, new Comparator<Pair<String, Double>>() {
            @Override
            public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {

                if (o1.getValue() < o2.getValue()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        List<String> updatedMerchantList = new ArrayList<>();
        for(Pair<String,Double> pair : merchantScore ){
            updatedMerchantList.add(pair.getKey());
            System.out.println("+========+++" +pair.getKey() +"+++++====== score " + pair.getValue());
        }
        product.setMerchantlist(String.join(",",updatedMerchantList));

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
            int price = restTemplate.getForObject(inventoryUri+"getprice/"+productInfoForList1.getProductid()+"/"+
                    merchantId,Integer.class);

            productInfoToUITemp.setPrice(price);

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
    public List<ProductInfoToListUI> findByNameIgnoreCase(String name ){
        List<Product> products = productRepository.findByNameIgnoreCase(name);
        return toProductInfoToListUI(products);
    }

    @Override
    public List<ProductInfoToListUI> findByNameContainingSubString(String name) {
        List<Product> products = productRepository.findByNameContainingIgnoreCase(name);

        return toProductInfoToListUI(products);
    }

    public List<ProductInfoToListUI> toProductInfoToListUI(List<Product> products){
        List<ProductInfoToListUI> productInfoToListUIS = new ArrayList<>();

        for (Product product : products){
            ProductInfoToListUI productInfoToUITemp = new ProductInfoToListUI();
            productInfoToUITemp.setProductid(product.getProductid());
            productInfoToUITemp.setName(product.getName());
            productInfoToUITemp.setImageurl(product.getImageurl());
            productInfoToUITemp.setRating(product.getRating());
            String merchantId = getDefaultMerchant(product.getProductid());

            int price = restTemplate.getForObject(inventoryUri+"getprice/"+product.getProductid()+"/"+
                    merchantId,Integer.class);
            productInfoToUITemp.setPrice(price);

            productInfoToListUIS.add(productInfoToUITemp);
        }

        return productInfoToListUIS;
    }

}
