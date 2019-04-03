package cz.upce.inpia.simpleshop.service;

import cz.upce.inpia.simpleshop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer productId);
}
