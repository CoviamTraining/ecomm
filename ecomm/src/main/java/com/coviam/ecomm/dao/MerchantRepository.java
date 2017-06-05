package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Merchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by gaurav on 03/06/17.
 */
public interface MerchantRepository extends CrudRepository<Merchant, Long> {

    @Query("select m.name,m.logo,m.rating from Merchant m where m.id = :id ")
    Object getMerchantNameLogoRating(@Param("id") Long id);

    @Query("select m.productsold,m.distinctproduct from Merchant m where m.id = :id ")
    Object getProductSoldDistinctProduct(@Param("id") Long id);


}
