package com.shoppingApplication.order_service.dto;

//import com.shoppingApplication.order_service.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class OrderEventDTO {
    private String message;
    private String status;
}
