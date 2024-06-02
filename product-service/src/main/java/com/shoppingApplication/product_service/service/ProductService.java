package com.shoppingApplication.product_service.service;

import com.shoppingApplication.product_service.dto.ProductRequest;
import com.shoppingApplication.product_service.model.Product;
import com.shoppingApplication.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    public final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product{}is saved successfully",product.getId());

    }

}
