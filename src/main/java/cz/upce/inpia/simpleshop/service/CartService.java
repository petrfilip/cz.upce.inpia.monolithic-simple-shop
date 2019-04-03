package cz.upce.inpia.simpleshop.service;

import cz.upce.inpia.simpleshop.model.Product;

import java.util.Map;

public interface CartService {

    void addProductToCart(Product product);

    void removeProductFromCart(Product product);

    Map<Product, Integer> getCart();

    void checkout();

}
