package com.shoppingApplication.order_service.controller;



@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProducer orderProducer;    @PostMapping("/addorder")
    public OrderResponse saveOrder(@RequestBody OrderDTO orderDTO) {
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setMessage("Order is committed");
        orderEventDTO.setStatus("pending");
        orderProducer.sendMessage(orderEventDTO);

        return orderService.saveOrder(orderDTO);
    }
    @GetMapping("/getorders")
    public List<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    } 
    
    @GetMapping("/order/{orderId}")
    public OrderDTO getOrderById(@PathVariable Integer orderId) {
        return orderService.getOrderById(orderId);
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
