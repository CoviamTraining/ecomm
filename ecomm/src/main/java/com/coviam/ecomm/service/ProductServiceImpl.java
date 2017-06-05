package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.CategoryRepository;
import com.coviam.ecomm.dao.MerchantRepository;
import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MerchantRepository merchantRepository;


    @Override
    public Product getProduct(int id) {
        return null;
    }

    @Override
    public boolean updatemerchantlist(Product product) {
        return false;
    }

    @Override
    public Object[] findByName(String name) {
        return new Object[0];
    }

    @Override
    public List<Object[]> getproductNameImageRating(int id) {
        return null;
    }

    @Override
    public List<String> getMerchantList(int id) {
        return null;
    }

    @Override
    public String getDefaultMerchant(int id) {
        return null;
    }
}
