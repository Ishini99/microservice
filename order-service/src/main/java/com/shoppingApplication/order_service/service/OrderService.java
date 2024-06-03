package com.shoppingApplication.order_service.service;
import com.shoppingApplication.order_service.dto.OrderRequest;
import com.shoppingApplication.order_service.model.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        


    }
}
