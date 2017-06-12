package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.dto.ProductInfoForList;
import com.coviam.ecomm.dto.ProductInfoToListUI;
import com.coviam.ecomm.dto.ProductOnDetailPage;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public interface ProductService {

    public ProductOnDetailPage getProduct(int id);

    public Product updatemerchantlist(int productId);

    public List<Product> findByName(String name);

    public ProductInfoForList getProductNameImageRating(int id);

    public List<String> getProductImages(int id);

    public List<String> getMerchantList(int id);

    public String getDefaultMerchant(int id);

    public List<ProductInfoToListUI> getProductByCategory(int categoryid);

    public String getProductImage(int i);

    public List<ProductInfoToListUI> findByNameIgnoreCase(String name);

    public List<ProductInfoToListUI> findByNameContainingSubString(String name);

    public String addToMerchantList(int productId, int merchantId);
}
