package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.entity.ProductInfoForList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return productRepository.findOne((long)id);
    }

    @Override
    public Product updatemerchantlist(Product product) {
        //TODO
        return productRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductInfoForList getProductNameRating(int id) {
        return productRepository.getproductNameRating(id);
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
    public List<ProductInfoForList> getProductByCategory(int categoryid) {
        return productRepository.getByCategory(categoryid);
    }


}
