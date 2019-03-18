package cz.upce.inpia.simpleshop.dao;

import cz.upce.inpia.simpleshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
