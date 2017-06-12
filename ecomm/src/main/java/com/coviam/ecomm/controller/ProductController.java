package com.coviam.ecomm.controller;

import com.coviam.ecomm.dao.ProductRepository;
import com.coviam.ecomm.dto.ProductInfoForList;
import com.coviam.ecomm.dto.ProductInfoToListUI;
import com.coviam.ecomm.dto.ProductOnDetailPage;
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

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/getProduct/{id}")
    public ProductOnDetailPage getProduct(@PathVariable Integer id){
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/updateMerchantList/{productId}")
    public String updateMerchantList(@PathVariable int productId){
       productService.updatemerchantlist(productId);
        return "SuccessFully Updated";
    }

    @RequestMapping(value = "/getProductByNameSubString/{name}")
    public List<ProductInfoToListUI> getProductByNameSubString(@PathVariable String name){
        return productService.findByNameContainingSubString(name);
    }

    @RequestMapping(value = "/getProductByNameIgnoreCase/{name}")
    List<ProductInfoToListUI> getProductByNameIgnoreCase(@PathVariable String name){
        return productService.findByNameIgnoreCase(name);
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

    @RequestMapping(value = "/getProductByCategory/{categoryid}")
    public List<ProductInfoToListUI> getProductByCategory(@PathVariable("categoryid") Long categoryid){
        return productService.getProductByCategory(Math.toIntExact(categoryid));
    }

    @RequestMapping(value = "/addMerchant/{productId}/{merchantId}")
    public String addMerchant(@PathVariable int productId, @PathVariable int merchantId){
        return productService.addToMerchantList(productId,merchantId);
    }
}
