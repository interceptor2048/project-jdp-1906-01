package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.controller.exceptions.OrderNotFoundException;
import com.kodilla.ecommerce.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.domain.dto.OrderDto;
import com.kodilla.ecommerce.maper.OrderMapper;
import com.kodilla.ecommerce.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public OrderDto getOrder(@RequestParam("orderId") Long orderId) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderDbService.getOrder(orderId).orElseThrow(OrderNotFoundException::new));
    }

    @PostMapping(value = "createOrder", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) throws UserNotFoundException{
        UserEntity user = orderDbService.findUser(orderDto.getUser_name()).orElseThrow(UserNotFoundException::new);
        orderDbService.addOrder(orderMapper.mapToOrder(orderDto, user));
    }

    @PutMapping(value = "updateOrder", consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        UserEntity user = orderDbService.findUser(orderDto.getUser_name()).orElseThrow(UserNotFoundException::new);
        return orderMapper.mapToOrderDto(orderDbService.addOrder(orderMapper.mapToOrder(orderDto, user)));
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") Long orderId) throws OrderNotFoundException {
        if (!orderDbService.getOrder(orderId).isPresent()) {
            throw new OrderNotFoundException();
        }
        orderDbService.deleteOrder(orderId);
    }
}
