package com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto;

import java.util.List;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto.CreateAddressDto;

import lombok.Getter;

@Getter
public class CreateCustomerDto {
  private String nombre;
  private String email;
  private String telefono;
  private List<CreateAddressDto> addresses;
}
