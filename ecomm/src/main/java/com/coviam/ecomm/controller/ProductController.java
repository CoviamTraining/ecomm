package com.coviam.ecomm.controller;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.entity.ProductInfoForList;
import com.coviam.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/getProduct/{id}")
    public Product getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    //TODO add mapping
    public Product updatemerchantlist(Product product){
        return productService.updatemerchantlist(product);
    }

    @RequestMapping(value = "/getProductbyName/{name}")
    public List<Product> getproductbyname(@PathVariable String name){
        return productService.findByName(name);
    }

    @RequestMapping(value = "/getProductNameImageRating/{id}")
    public ProductInfoForList getProductNameRating(@PathVariable Long id){
        return productService.getProductNameImageRating(Math.toIntExact(id));
    }

    @RequestMapping(value = "/getProductImage/{id}")
    public String getImage(@PathVariable Long id){
        return productService.getProductImage(Math.toIntExact(id));
    }

    @RequestMapping(value = "/getProductImages/{id}")
    public List<String> getImages(@PathVariable Long id){
        return productService.getProductImages(Math.toIntExact(id));
    }

    @RequestMapping(value = "/getMerchantList/{id}")
    public List<String> getMerchantList(@PathVariable Long id){
        return productService.getMerchantList(Math.toIntExact(id));
    }

    @RequestMapping(value = "/getDefaultMerchant/{id}")
    public String getDefaultMerchant(@PathVariable Long id){
        return productService.getDefaultMerchant(Math.toIntExact(id));
    }

    @RequestMapping(value = "/testgetproductimageratingname/{id}")
    public String testgetProductNameRating(@PathVariable Long id){
        return productService.getProductNameImageRating(Math.toIntExact(id)).toString();
    }



    @RequestMapping(value = "/getProductByCategory/{categoryid}")
    public List<ProductInfoForList> getProductByCategory(@PathVariable("categoryid") Long categoryid){
        return productService.getProductByCategory(Math.toIntExact(categoryid));
    }

    @RequestMapping(value = "/testgetProductByCategory/{categoryid}")
    public String testgetProductByCategory(@PathVariable("categoryid") Long categoryid){
        return " " + productService.getProductByCategory(Math.toIntExact(categoryid)).size();
    }

}
