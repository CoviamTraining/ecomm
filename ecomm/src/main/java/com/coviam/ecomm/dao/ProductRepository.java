package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Category;
import com.coviam.ecomm.entity.Product;
import com.coviam.ecomm.entity.ProductInfoForList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */

public interface ProductRepository extends CrudRepository<Product,Integer>{

    List<Product> findByName(String name);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByNameIgnoreCase(String name);

    @Query("select new com.coviam.ecomm.entity.ProductInfoForList(p.productid, p.name,p.imageurl,p.rating) from Product p where p.productid = :id")
    ProductInfoForList getproductNameImageRating(@Param("id") int id);

    @Query("select p.merchantlist from Product p where p.productid = :id ")
    String getMerchantList(@Param("id") int id);

    @Query("select p.merchantlist from Product p where p.productid = :id ")
    String getDefaultMerchant(@Param("id") int id);

    @Query("select p.imageurl from Product p where p.productid = :id ")
    String getImages(@Param("id") int id);

    @Query("select new com.coviam.ecomm.entity.ProductInfoForList(p.productid, p.name,p.imageurl,p.rating) " +
            "from Product p left join p.category c where  c.categoryid = :categoryid")
    List<ProductInfoForList> getByCategory(@Param("categoryid") int categoryid);


}
