package cz.upce.inpia.simpleshop.dao;

import cz.upce.inpia.simpleshop.model.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductDao extends JpaRepository<OrderedProduct, Integer> {
}
