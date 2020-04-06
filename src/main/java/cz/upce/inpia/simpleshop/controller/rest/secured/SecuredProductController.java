package cz.upce.inpia.simpleshop.controller.rest.secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secured/product")
public class SecuredProductController {

  @GetMapping
  public String getMessage() {
    return "Hello from private API controller";
  }
}