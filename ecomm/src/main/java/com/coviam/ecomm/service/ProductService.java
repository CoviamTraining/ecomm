package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Product;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public interface ProductService {

    public Product getProduct(Long id);

    public Product updatemerchantlist(Product product);

    public List<Product> findByName(String name);

    public Object getProductNameImageRating(Long id);

    public List<String> getMerchantList(Long id);

    public String getDefaultMerchant(Long id);

}
