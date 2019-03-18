package cz.upce.inpia.simpleshop.controller;

import cz.upce.inpia.simpleshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @GetMapping("/product/detail/{productId}")
    public String getProductById(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return "product-detail";
    }
}
