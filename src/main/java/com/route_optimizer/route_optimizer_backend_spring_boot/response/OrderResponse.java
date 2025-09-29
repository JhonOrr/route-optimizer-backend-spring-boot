package com.route_optimizer.route_optimizer_backend_spring_boot.response;

import java.time.LocalDate;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {

  private Long Id;
  private String orderNumber;
  private LocalDate orderDate;
  private Integer status;
  private Double weight;
  private Customer customer;
  private AddressResponse deliveryAddress;
  private AddressResponse pickupAddress;
}
