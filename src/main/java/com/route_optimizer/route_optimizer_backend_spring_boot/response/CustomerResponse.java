package com.route_optimizer.route_optimizer_backend_spring_boot.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
  private Long id;
  private String nombre;
  private String email;
  private String telefono;
  private Integer status;
  List<AddressResponse> addresses;
}
