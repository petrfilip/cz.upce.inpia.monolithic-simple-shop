package cz.upce.inpia.simpleshop.controller.rest;

import cz.upce.inpia.simpleshop.model.Product;
import cz.upce.inpia.simpleshop.service.CartService;
import cz.upce.inpia.simpleshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class RestCartController {

    private final CartService cartService;

    private final ProductService productService;

    @Autowired
    public RestCartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public Map<Product, Integer> getCart() {
        return cartService.getCart();
    }

    @PostMapping("{productId}")
    public Map<Product, Integer> addProductToCart(@PathVariable("productId") Integer productId) {
        Product byId = productService.findById(productId);
        cartService.addProductToCart(byId);
        return cartService.getCart();
    }

    @DeleteMapping("{productId}")
    public Map<Product, Integer> removeProductFromCart(@PathVariable("productId") Integer productId) {
        Product byId = productService.findById(productId);
        cartService.removeProductFromCart(byId);
        return cartService.getCart();
    }
}
