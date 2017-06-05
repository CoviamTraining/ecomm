package com.coviam.ecomm.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by gaurav on 03/06/17.
 */

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryid;

    @Column(name = "name",length = 20)
    private String name;

    public Category() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", name='" + name + '\'' +
                '}';
    }
}
