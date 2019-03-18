package cz.upce.inpia.simpleshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableWebMvc
public class InpiaSimpleShopApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(InpiaSimpleShopApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/thymeleaf/static/**")) {
            registry.addResourceHandler("/thymeleaf/static/**")
                    .addResourceLocations("classpath:/thymeleaf/static/");
        }
    }

}

