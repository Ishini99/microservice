package com.shoppingApplication.inventory_service.controller;

import com.shoppingApplication.inventory_service.dto.InventoryDTO;
import com.shoppingApplication.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService; // Inject InventoryService

    @GetMapping("/getitems")
    public List<InventoryDTO> getItems() {
        return inventoryService.getAllItems(); // Call the service to get all items
    }

    @GetMapping("/item/{itemId}")
    public InventoryDTO getItemById(@PathVariable Integer itemId) {
        return inventoryService.getItemById(itemId); // Get an item by its ID
    }

    @PostMapping("/additem")
    public InventoryDTO saveItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.saveItem(inventoryDTO); // Save a new item
    }

    @PutMapping("/updateitem")
    public InventoryDTO updateItem(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.updateItem(inventoryDTO); // Update an existing item
    }

    @DeleteMapping("/deleteitem/{itemId}")
    public String deleteItem(@PathVariable Integer itemId) {
        return inventoryService.deleteItem(itemId); // Delete an item by its ID
    }
}
