package com.coviam.ecomm.controller;

import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/getproduct/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    //TODO add mapping
    public Product updatemerchantlist(Product product){
        return productService.updatemerchantlist(product);
    }

    @RequestMapping(value = "/getproductbyname/{name}")
    public List<Product> getproductbyname(@PathVariable String name){
        return productService.findByName(name);
    }

    @RequestMapping(value = "/getproductimageratingname/{id}")
    public Object getProductNameRating(@PathVariable Long id){
        return productService.getProductNameRating(id);
    }

    @RequestMapping(value = "/getproductimages/{id}")
    public List<String> getImages(@PathVariable Long id){
        return productService.getProductImages(id);
    }

    @RequestMapping(value = "/getmerchantlist/{id}")
    public List<String> getMerchantList(@PathVariable Long id){
        return productService.getMerchantList(id);
    }

    @RequestMapping(value = "/getdefaultmerchant/{id}")
    public String getDefaultMerchant(@PathVariable Long id){
        return productService.getDefaultMerchant(id);
    }
}
