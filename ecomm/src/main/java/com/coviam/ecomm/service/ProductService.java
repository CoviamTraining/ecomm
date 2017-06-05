package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Product;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public interface ProductService {

    public Product getProduct(int id);

    public boolean updatemerchantlist(Product product);

    public Object[] findByName(String name);

    public List<Object[]> getproductNameImageRating(int id);

    public List<String> getMerchantList(int id);

    public String getDefaultMerchant(int id);

}
