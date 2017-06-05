package com.coviam.ecomm.controller;

import com.coviam.ecomm.entity.Merchant;
import com.coviam.ecomm.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaurav on 05/06/17.
 */
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "/getmerchant/{id}")
    public Merchant getMerchant(@PathVariable Long id){
        return merchantService.getMerchant(id);
    }

    @RequestMapping(value = "/getmerchantnamelogorating/{id}")
    public Object getMerchantNameLogoRating(@PathVariable Long id){
        return merchantService.getMerchantNameLogoRating(id);
    }

    @RequestMapping(value = "/getsoldanddistinctproduct/{id}")
    public Object getSoldAndDistinctProduct(@PathVariable Long id){
        return merchantService.getProductSoldDistinctProduct(id);
    }
}
