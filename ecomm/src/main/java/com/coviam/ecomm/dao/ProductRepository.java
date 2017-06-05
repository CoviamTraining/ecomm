package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */

public interface ProductRepository extends CrudRepository<Product,Long>{

    List<Product> findByName(String name);

    @Query("select p.name,p.image,p.rating from Product p where p.id = ?")
    List<Object> getproductNameImageRating(int id);

    @Query("select p.merchantlist from Product p where p.id = ? ")
    List<String> getMerchantList(int id);

    @Query("select p.merchantlist[0] from Product p where p.id = ?")
    String getDefaultMerchant(int id);

}
