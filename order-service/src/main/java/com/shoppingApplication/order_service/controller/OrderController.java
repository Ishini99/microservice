package com.shoppingApplication.order_service.controller;


import com.shoppingApplication.order_service.dto.OrderDTO;
import com.shoppingApplication.order_service.dto.OrderEventDTO;
import com.shoppingApplication.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
//    private OrderProducer orderProducer;

    @GetMapping("/getorders")
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/addorder")
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO) {
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setMessage("Order is committed");
        orderEventDTO.setStatus("pending");
        orderProducer.sendMessage(orderEventDTO);

        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/updateorder")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }

    @DeleteMapping("/deleteorder/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteOrder(orderId);
    }
}
