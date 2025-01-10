package com.shoppingApplication.order_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
    @Id
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;
}
