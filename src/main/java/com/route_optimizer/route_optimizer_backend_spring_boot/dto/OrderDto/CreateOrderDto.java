package com.route_optimizer.route_optimizer_backend_spring_boot.dto.OrderDto;

import java.time.LocalDate;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto.CreateAddressDto;

import lombok.Getter;

@Getter
public class CreateOrderDto {
  private Long customerId;
  private LocalDate orderDate;
  private Long pickupAddressId;
  private Double weight;
  private CreateAddressDto deliveryAddress;
}
