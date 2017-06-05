package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gaurav on 03/06/17.
 */
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

    @Query("select m.name,m.logo,m.rating from Merchant m where m.id = ? ")
    Object getMerchantNameLogoRating(int id);

    @Query("select m.productsold,m.distinctproduct from Merchant m where m.id = ? ")
    Object getProductSoldDistinctProduct(int id);


}
