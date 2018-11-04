package com.siri.shoppingbackend.dao;

import com.siri.shoppingbackend.dto.Product;

import java.util.List;

public interface ProductDAO {

    List litsProducts();
    Product get(int id);
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);

    //business methods
    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory( int categoryId);
    List<Product> getLatestActiveProducts(int count);

}
