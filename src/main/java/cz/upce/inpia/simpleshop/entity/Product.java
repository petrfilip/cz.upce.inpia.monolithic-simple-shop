package cz.upce.inpia.simpleshop.entity;

import cz.upce.inpia.simpleshop.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;

    private String slugName;

    private Double price;

    private String description;

    private boolean isActive;



}
