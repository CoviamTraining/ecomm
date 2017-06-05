package com.coviam.ecomm.service;

import com.coviam.ecomm.dao.MerchantRepository;
import com.coviam.ecomm.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaurav on 05/06/17.
 */
@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant getMerchant(Long id) {
        return merchantRepository.findOne(id);
    }

    @Override
    public Object getMerchantNameLogoRating(Long id) {
        return merchantRepository.getMerchantNameLogoRating(id);
    }

    @Override
    public Object getProductSoldDistinctProduct(Long id) {
        return merchantRepository.getProductSoldDistinctProduct(id);
    }
}
