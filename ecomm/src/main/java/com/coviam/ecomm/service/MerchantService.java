package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Merchant;

/**
 * Created by gaurav on 05/06/17.
 */
public interface MerchantService {

    public Merchant getMerchant(Long id);

    public Object getMerchantNameLogoRating(Long id);

    public Object getProductSoldDistinctProduct(Long id);


}
