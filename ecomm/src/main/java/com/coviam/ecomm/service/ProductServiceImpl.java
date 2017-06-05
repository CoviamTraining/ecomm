package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.CategoryRepository;
import com.coviam.ecomm.dao.MerchantRepository;
import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.Product;
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
    public Product getProduct(Long id) {
        return productRepository.findOne(id);
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
    public Object getProductNameRating(Long id) {
        return productRepository.getproductNameRating(id);
    }

    @Override
    public List<String> getProductImages(Long id) {
        String images = productRepository.getImages(id);
        return Arrays.asList(images.split(","));
    }

    @Override
    public List<String> getMerchantList(Long id) {
        String merchants = productRepository.getMerchantList(id);
        List<String> merchantsList = Arrays.asList(merchants.split(","));
        return merchantsList;
    }

    @Override
    public String getDefaultMerchant(Long id) {
        String merchants = productRepository.getMerchantList(id);
        List<String> merchantsList = Arrays.asList(merchants.split(","));
        return merchantsList.get(0);
    }
}
