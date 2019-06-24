package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/order")
public class OrderController {
    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto order) {
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam("orderId") Long orderId) {
        return new OrderDto(1, 2);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto order) {
        return order;
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam("orderId") Long orderId) {
    }
}
