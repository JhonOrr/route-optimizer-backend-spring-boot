package com.route_optimizer.route_optimizer_backend_spring_boot.mappers;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Order;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.OrderResponse;

public class OrderMapper {

  public static OrderResponse toResponse(Order order, AddressResponse deliveryAddress, AddressResponse pickupAddress){
    OrderResponse orderResponse = new OrderResponse();

    orderResponse.setCustomer(order.getCustomer());
    orderResponse.setDeliveryAddress(deliveryAddress);
    orderResponse.setId(order.getId());
    orderResponse.setOrderDate(order.getOrderDate());
    orderResponse.setOrderNumber(order.getOrderNumber());
    orderResponse.setPickupAddress(pickupAddress);
    orderResponse.setStatus(order.getStatus());
    orderResponse.setWeight(order.getWeight());

    return orderResponse;
  }
}
