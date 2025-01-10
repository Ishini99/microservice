package com.shoppingApplication.order_service.repository;

import com.shoppingApplication.order_service.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT * FROM order WHERE id = ?1", nativeQuery = true)
    Orders getOrderById(Integer orderId);
}
