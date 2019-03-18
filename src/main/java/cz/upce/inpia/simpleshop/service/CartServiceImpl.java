package cz.upce.inpia.simpleshop.service;

import cz.upce.inpia.simpleshop.dao.OrderFormDao;
import cz.upce.inpia.simpleshop.dao.OrderedProductDao;
import cz.upce.inpia.simpleshop.entity.OrderForm;
import cz.upce.inpia.simpleshop.entity.OrderState;
import cz.upce.inpia.simpleshop.entity.Product;
import cz.upce.inpia.simpleshop.entity.OrderedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CartServiceImpl implements CartService {

    private OrderFormDao orderFormDao;
    private final OrderedProductDao orderedProductDao;

    private Map<Product, Integer> cart = new HashMap<>();

    @Autowired
    public CartServiceImpl(OrderedProductDao orderedProductDao, OrderFormDao orderFormDao) {
        this.orderedProductDao = orderedProductDao;
        this.orderFormDao = orderFormDao;
    }

    @Override
    public void addProductToCart(Product product) {
        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product) + 1);
        } else {
            cart.put(product, 1);
        }
    }

    @Override
    public void removeProductFromCart(Product product) {
        if (cart.containsKey(product)) {
            if (cart.get(product) > 1)
                cart.replace(product, cart.get(product) - 1);
            else if (cart.get(product) == 1) {
                cart.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getCart() {
        return Collections.unmodifiableMap(cart);
    }

    @Override
    public void checkout() {

        OrderForm orderForm = new OrderForm();
        orderForm.setOrderState(OrderState.NEW);
        orderFormDao.save(orderForm);

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setOrder(orderForm);
            orderedProduct.setProduct(entry.getKey());
            orderedProduct.setAmount(entry.getValue());
            orderedProductDao.save(orderedProduct);
        }
        orderedProductDao.flush();
        cart.clear();
    }
}
