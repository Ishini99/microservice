package com.shoppingApplication.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.shoppingApplication.product_service.model.Product;
import org.springframework.data.mongodb.repository.Query;

public interface ProductRepository extends MongoRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product WHERE product_id = ?1")
    Product getProductById(Integer productId);
}
