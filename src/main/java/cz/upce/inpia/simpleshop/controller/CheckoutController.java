package cz.upce.inpia.simpleshop.controller;

import cz.upce.inpia.simpleshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {

    private final CartService cartService;

    @Autowired
    public CheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/checkout")
    public String checkout() {
        cartService.checkout();
        return "checkout";
    }
}
