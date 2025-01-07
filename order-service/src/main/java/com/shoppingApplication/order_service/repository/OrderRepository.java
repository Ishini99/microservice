package com.shoppingApplication.order_service.repository;

import com.shoppingApplication.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT * FROM order WHERE id = ?1", nativeQuery = true)
    Orders getOrderById(Integer orderId);
}

