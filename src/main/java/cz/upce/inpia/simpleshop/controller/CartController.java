package cz.upce.inpia.simpleshop.controller;

import cz.upce.inpia.simpleshop.entity.Product;
import cz.upce.inpia.simpleshop.service.ProductServiceImpl;
import cz.upce.inpia.simpleshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    private final CartService cartService;

    private final ProductServiceImpl productService;

    @Autowired
    public CartController(CartService cartService, ProductServiceImpl productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }

    @GetMapping("/cart/add/{productId}")
    public ModelAndView addProductToCart(@PathVariable("productId") Integer productId, ModelMap model) {
        Product byId = productService.findById(productId);
        cartService.addProductToCart(byId);
        model.addAttribute("cart", cartService.getCart());
        return new ModelAndView("cart", model);
    }

    @GetMapping("/cart/remove/{productId}")
    public String removeProductFromCart(@PathVariable("productId") Integer productId, Model model) {
        Product byId = productService.findById(productId);
        cartService.removeProductFromCart(byId);
        model.addAttribute("cart", cartService.getCart());
        return "cart";
    }
}
