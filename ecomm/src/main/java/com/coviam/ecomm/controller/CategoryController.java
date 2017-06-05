package com.coviam.ecomm.controller;

import com.coviam.ecomm.dao.CategoryRepository;
import com.coviam.ecomm.entity.Category;
import com.coviam.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gaurav on 05/06/17.
 */

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping (value = "/addcategory/{name}")
    public void addCategory(@PathVariable String name){
        Category category = new Category();
        category.setName(name);
        categoryService.addCategory(name);
    }

    @RequestMapping(value = "/getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @RequestMapping(value = "/getcategory/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }


}
