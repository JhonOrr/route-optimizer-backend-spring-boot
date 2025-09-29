package com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto;

import lombok.Getter;

@Getter
public class CreateAddressDto {
  private String address;
  private String district;
  private String city;  
  private Double latitude;
  private Double longitude;
}
