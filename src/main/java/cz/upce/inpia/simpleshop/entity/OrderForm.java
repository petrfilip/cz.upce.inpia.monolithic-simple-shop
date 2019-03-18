package cz.upce.inpia.simpleshop.entity;

import cz.upce.inpia.simpleshop.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class OrderForm extends BaseEntity {

    @OneToMany(mappedBy = "id")
    private Set<OrderedProduct> orderedProducts;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;
}
