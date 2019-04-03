package cz.upce.inpia.simpleshop.model;

import cz.upce.inpia.simpleshop.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class OrderedProduct extends BaseEntity {

    @ManyToOne
    private OrderForm order;

    @ManyToOne
    private Product product;

    @Column
    private Integer amount;

}
