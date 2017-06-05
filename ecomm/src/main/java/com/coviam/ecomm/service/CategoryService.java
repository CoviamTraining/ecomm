package com.coviam.ecomm.service;

import com.coviam.ecomm.entity.Category;

/**
 * Created by gaurav on 05/06/17.
 */
public interface CategoryService {

    public Category getCategory(int id);

    public Category addCategory(String name);

    public void deleteCategory(int id);

    public void updateCategory(Category category);

}
