package com.shoppingApplication.order_service.service;

import com.shoppingApplication.order_service.dto.OrderDTO;
import com.shoppingApplication.order_service.model.Orders;
import com.shoppingApplication.order_service.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
//    private final WebClient inventoryWebClient;
//    private final WebClient productWebClient;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient inventoryWebClient, WebClient productWebClient, OrderRepo orderRepo, ModelMapper modelMapper) {
        this.inventoryWebClient = inventoryWebClient;
        this.productWebClient = productWebClient;
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders>orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public OrderResponse saveOrder(OrderDTO OrderDTO) {

        Integer itemId = OrderDTO.getItemId();

        try {
            InventoryDTO inventoryResponse = inventoryWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();

            assert inventoryResponse != null;

            Integer productId = inventoryResponse.getProductId();

            ProductDTO productResponse = productWebClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/product/{productId}").build(productId))
                    .retrieve()
                    .bodyToMono(ProductDTO.class)
                    .block();

            assert productResponse != null;

            if (inventoryResponse.getQuantity() > 0) {
                if (productResponse.getForSale() == 1) {
                    orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
                }
                else {
                    return new ErrorOrderResponse("This item is not for sale");
                }
                return new SuccessOrderResponse(OrderDTO);
            }
            else {
                return new ErrorOrderResponse("Item not available, please try later");
            }

        }
        catch (WebClientResponseException e) {
            if (e.getStatusCode().is5xxServerError()) {
                return new ErrorOrderResponse("Item not found");
            }
        }

        return null;
    }

    public OrderDTO updateOrder(OrderDTO OrderDTO) {
        orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
        return OrderDTO;
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }
}
