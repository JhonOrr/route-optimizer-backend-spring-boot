package com.route_optimizer.route_optimizer_backend_spring_boot.dto.OrderDto;

import java.time.LocalDate;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;

import lombok.Getter;

@Getter
public class CreateOrderDto {
  private LocalDate orderDate;
  private Double weight;
  private Long customerId;
  private Long addressId;
  private Address pickupAddress;
  private Address deliveryAddress;
}
