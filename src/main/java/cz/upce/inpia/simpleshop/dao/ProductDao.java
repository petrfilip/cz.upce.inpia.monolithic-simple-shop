package cz.upce.inpia.simpleshop.dao;

import cz.upce.inpia.simpleshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
