package com.kodilla.ecommerce.maper;

import com.kodilla.ecommerce.domain.OrderEntity;
import com.kodilla.ecommerce.domain.OrderProduct;
import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.domain.dto.OrderDto;
import com.kodilla.ecommerce.domain.dto.OrderedProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public List<OrderDto> mapToOrderDtoList(final List<OrderEntity> orders){
        return orders.stream()
                .map(order -> new OrderDto(order.getId(), order.getUser().getUserName(), mapToProductDtoList(order.getProducts())))
                .collect(Collectors.toList());
    }

    public OrderEntity mapToOrder(OrderDto orderDto, UserEntity user) {
        OrderEntity order = new OrderEntity();
        order.setUser(user);
        user.getOrders().add(order);
        order.getProducts().addAll(mapToProductList(orderDto.getProducts(), order));
        return order;
    }

    public OrderDto mapToOrderDto(final OrderEntity order) {
        return new OrderDto(order.getId(), order.getUser().getUserName(), mapToProductDtoList(order.getProducts()));
    }

    private List<OrderedProductDto> mapToProductDtoList(List<OrderProduct> orderProductList){
        List<OrderedProductDto> productsInOrder = new ArrayList<>();
        for (OrderProduct orderProduct : orderProductList) {
            productsInOrder.add(new OrderedProductDto(orderProduct.getProduct().getId(), orderProduct.getProduct().getName(), orderProduct.getProduct().getDescription(), orderProduct.getProduct().getPrice(), orderProduct.getQuantity()));
        }
        return productsInOrder;
    }

    private List<OrderProduct> mapToProductList(List<OrderedProductDto> products, OrderEntity order){
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderedProductDto product : products) {
            ProductEntity productEntity = new ProductEntity(product.getName(), product.getDescription(), product.getPrice());
            OrderProduct orderProduct = new OrderProduct(order, productEntity, product.getQuantity());
            productEntity.getOrders().add(orderProduct);
            orderProducts.add(orderProduct);
        }
        return orderProducts;
    }
}
