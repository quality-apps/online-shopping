package com.siri.shoppingbackend.dao;

import com.siri.shoppingbackend.dto.Category;

import java.util.List;

public interface CategoryDAO {

    List litsCategory();

    Category get(int id);

    boolean add( Category category);
    boolean update( Category category);
    boolean delete( Category category);

}
