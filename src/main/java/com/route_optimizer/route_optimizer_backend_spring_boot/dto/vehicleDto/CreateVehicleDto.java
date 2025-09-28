package com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVehicleDto {
  private String placa;
  private String marca;
  private String modelo;
  private Double capacity;
}
