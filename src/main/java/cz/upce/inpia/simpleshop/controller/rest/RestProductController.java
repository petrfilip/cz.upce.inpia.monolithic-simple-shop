package cz.upce.inpia.simpleshop.controller.rest;

import cz.upce.inpia.simpleshop.model.Product;
import cz.upce.inpia.simpleshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin
public class RestProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public RestProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("{productId}")
    public Product getProductById(@PathVariable Integer productId) {
        return productService.findById(productId);
    }

}
