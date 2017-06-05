package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */

public interface ProductRepository extends CrudRepository<Product,Long>{

    List<Product> findByName(String name);

    @Query("select p.name,p.rating from Product p where p.productid = :id")
    List<Object> getproductNameRating(@Param("id") Long id);

    @Query("select p.merchantlist from Product p where p.productid = :id ")
    String getMerchantList(@Param("id") Long id);

    @Query("select p.merchantlist from Product p where p.productid = :id ")
    String getDefaultMerchant(@Param("id") Long id);

    @Query("select p.imageurl from Product p where p.productid = :id ")
    String getImages(@Param("id") Long id);

}
