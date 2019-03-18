package cz.upce.inpia.simpleshop.controller.rest;

import cz.upce.inpia.simpleshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestCheckoutController {

    private final CartService cartService;

    @Autowired
    public RestCheckoutController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/api/checkout")
    public ResponseEntity<Object> checkout() {
        cartService.checkout();
        return ResponseEntity.ok().build();
    }
}
