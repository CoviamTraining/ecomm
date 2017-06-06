package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.entity.ProductInfoForList;
import com.coviam.ecomm.entity.ProductInfoToListUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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

    @Override
    public Product getProduct(int id) {
        return productRepository.findOne(id);
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

            RestTemplate restTemplate = new RestTemplate();
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
