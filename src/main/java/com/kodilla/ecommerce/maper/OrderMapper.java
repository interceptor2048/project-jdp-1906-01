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

    public OrderEntity mapToOrder(OrderDto orderDto, UserEntity user, List<ProductEntity> productEntityList) {
        OrderEntity order = createOrder(orderDto);
        user.getOrders().add(order);
        order.setUser(user);
        List<OrderProduct> orderProducts = createOrderProductList(orderDto.getProducts(), order, productEntityList);
        addOrderToProduct(productEntityList, orderProducts);
        order.getProducts().addAll(orderProducts);
        return order;
    }


    public OrderDto mapToOrderDto(final OrderEntity order) {
        return new OrderDto(order.getId(), order.getUser().getUserName(), mapToProductDtoList(order.getProducts()));
    }

    private List<OrderedProductDto> mapToProductDtoList(List<OrderProduct> orderProductList){
        List<OrderedProductDto> productsInOrder = new ArrayList<>();
        for (OrderProduct orderProduct : orderProductList) {
            productsInOrder.add(new OrderedProductDto(orderProduct.getId(), orderProduct.getProduct().getName(), orderProduct.getProduct().getDescription(), orderProduct.getProduct().getPrice(), orderProduct.getQuantity()));
        }
        return productsInOrder;
    }

    private List<OrderProduct> createOrderProductList(List<OrderedProductDto> orderedProductsDto, OrderEntity order, List<ProductEntity> productEntityList){
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (int i = 0; i < orderedProductsDto.size(); i ++) {
            OrderProduct orderProduct = createOrderProduct(orderedProductsDto.get(i).getId(), order, productEntityList.get(i), orderedProductsDto.get(i).getQuantity());
            orderProducts.add(orderProduct);
        }
        return orderProducts;
    }

    private void addOrderToProduct(List<ProductEntity> productEntityList, List<OrderProduct> orderProducts){
        for (ProductEntity productEntity : productEntityList) {
            for (OrderProduct orderProduct : orderProducts) {
                if (orderProduct.getProduct().getName().equals(productEntity.getName())) {
                    productEntity.getOrders().add(orderProduct);
                }
            }
        }
    }

    private OrderEntity createOrder(OrderDto orderDto){
        return (orderDto.getId() == 0) ? new OrderEntity() : new OrderEntity(orderDto.getId());
    }

    private OrderProduct createOrderProduct(Long id, OrderEntity order, ProductEntity productEntity, int quantity){
        return (id == null) ? new OrderProduct(order, productEntity, quantity) : new OrderProduct(id, order, productEntity, quantity);
    }
}
