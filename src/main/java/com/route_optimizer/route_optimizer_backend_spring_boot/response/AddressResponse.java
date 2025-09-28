package com.route_optimizer.route_optimizer_backend_spring_boot.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
  private Long Id;
  private String address;
  private String district;
  private String city;
  private Double latitude;
  private Double longitude;
}
