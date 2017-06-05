package com.coviam.ecomm.dao;

import com.coviam.ecomm.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by gaurav on 03/06/17.
 */
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
