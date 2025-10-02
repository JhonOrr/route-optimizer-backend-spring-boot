package com.route_optimizer.route_optimizer_backend_spring_boot.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "order_number")
  private String orderNumber;

  @Column(name = "order_date", nullable = false)
  private LocalDate orderDate;

  @Column(nullable = false, length = 50)
  private String status;

  @Column
  private Double weight;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "delivery_address_id")
  private Address deliveryAddress;

  @ManyToOne
  @JoinColumn(name = "pickup_address_id")
  private Address pickupAddress;
}
