package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.entity.ProductInfoForList;
import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public interface ProductService {

    public Product getProduct(int id);

    public Product updatemerchantlist(Product product);

    public List<Product> findByName(String name);

    public ProductInfoForList getProductNameImageRating(int id);

    public List<String> getProductImages(int id);

    public List<String> getMerchantList(int id);

    public String getDefaultMerchant(int id);

    public List<ProductInfoForList> getProductByCategory(int categoryid);

    public String getProductImage(int i);
}
