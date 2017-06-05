package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by gaurav on 03/06/17.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {

    @Query("select c from Category c")
    List<Category> getAllCategory();
}
