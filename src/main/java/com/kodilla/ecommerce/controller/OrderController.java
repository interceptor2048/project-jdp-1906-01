package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.controller.exceptions.OrderNotFoundException;
import com.kodilla.ecommerce.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommerce.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommerce.domain.OrderEntity;
import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.domain.dto.OrderDto;
import com.kodilla.ecommerce.maper.OrderMapper;
import com.kodilla.ecommerce.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommerce/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDbService orderDbService;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderDbService.getAllOrders());
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam("orderId") Long orderId) {
        return orderMapper.mapToOrderDto(orderDbService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @Transactional
    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        UserEntity user = orderDbService.findUser(orderDto.getUser_name()).orElseThrow(UserNotFoundException::new);
        checkIfProductsExist(orderDto);
        List<ProductEntity> productEntityList = createProductList(orderDto);
        orderDbService.addOrder(orderMapper.mapToOrder(orderDto, user, productEntityList));
    }

    @PutMapping(value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        UserEntity user = orderDbService.findUser(orderDto.getUser_name()).orElseThrow(UserNotFoundException::new);
        checkIfProductsExist(orderDto);
        OrderEntity order = createOrder(orderDto.getId(), user, orderDto);
        orderDbService.saveOrderProduct(order.getProducts().get(0));
        return orderMapper.mapToOrderDto(order);
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") Long orderId) {
        if (!orderDbService.getOrder(orderId).isPresent()) {
            throw new OrderNotFoundException();
        }
        orderDbService.deleteOrder(orderId);
    }

    private List<ProductEntity> createProductList(OrderDto orderDto) {
        List<ProductEntity> productEntityList = new ArrayList<>();
        orderDto.getProducts().stream()
                .forEach(product -> productEntityList.add(orderDbService.findProduct(product.getName()).get()));
        return productEntityList;
    }

    private void checkIfProductsExist (OrderDto orderDto) {
        orderDto.getProducts().stream()
                .forEach(product -> orderDbService.findProduct(product.getName()).orElseThrow(ProductNotFoundException::new));
    }

    private OrderEntity createOrder(Long id, UserEntity user, OrderDto orderDto){
        List<ProductEntity> productEntityList = createProductList(orderDto);
        OrderEntity order = orderDbService.findOrder(id).orElseThrow(OrderNotFoundException::new);
        order.getProducts().clear();
        order.setUser(user);
        user.getOrders().add(order);
        return orderMapper.mapToProducts(orderDto, order, productEntityList);
    }
}
