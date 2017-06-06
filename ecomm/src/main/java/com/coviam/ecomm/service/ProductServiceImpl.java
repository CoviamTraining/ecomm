package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        ArrayList<OtherMerchantToOffer> otherMerchantToOffers = new ArrayList<>();
        for(String merchant : merchants){
            OtherMerchantToOffer otherMerchantToOffer = restTemplate.getForObject(merchantUri+merchant,OtherMerchantToOffer.class);
            otherMerchantToOffers.add(otherMerchantToOffer);
        }
        productOnDetailPage.setOtherMerchantToOffer(otherMerchantToOffers);


        String productReviewUri = "http://172.16.20.13:8090/getproductfeedback/";
        ResponseEntity<List<ProductRatingReview>> responseEntity = restTemplate.exchange(productReviewUri + id, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<ProductRatingReview>>() {});
        List<ProductRatingReview> productReviewsObject = responseEntity.getBody();
        System.out.println("productReviewsobject -- class : " + productReviewsObject.getClass());
        List <ProductRatingReview> productRatingReviews = (List<ProductRatingReview>)(Object) productReviewsObject ;
        productOnDetailPage.setProductRatingReviews(productReviewsObject);

        return productOnDetailPage;
    }

    // TODO
    @Override
    public Product updatemerchantlist(Product product) {

        // number of products merchant offer to sell

        // number of product sold

        //

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


}
