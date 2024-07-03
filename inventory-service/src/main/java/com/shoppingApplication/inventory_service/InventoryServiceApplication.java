package com.shoppingApplication.inventory_service;

import com.shoppingApplication.inventory_service.model.Inventory;
import com.shoppingApplication.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("abc");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("abc1");
			inventory1.setQuantity(1000);
			Inventory inventory2 = new Inventory();
			inventory.setSkuCode("abc2");
			inventory.setQuantity(1500);

			Inventory inventory3 = new Inventory();
			inventory1.setSkuCode("abc3");
			inventory1.setQuantity(2000);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);
		};
	}
}
