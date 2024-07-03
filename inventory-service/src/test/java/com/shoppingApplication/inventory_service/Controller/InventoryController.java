package com.shoppingApplication.inventory_service.Controller;

import com.shoppingApplication.inventory_service.Service.InventoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;



    @GetMapping("/isku-code")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInSstock(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
