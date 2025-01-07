package com.shoppingApplication.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderLineItemsDto {
    private int id;
    private int itemId;
    private String orderDate;
    private int amount;
}
