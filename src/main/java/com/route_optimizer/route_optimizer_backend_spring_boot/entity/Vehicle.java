package com.route_optimizer.route_optimizer_backend_spring_boot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@RequiredArgsConstructor
public class Vehicle {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String placa;
  private String marca;
  private String modelo;
  @Column(name = "vehicle_capacity")
  private Double capacity;
  private Integer status;
}
