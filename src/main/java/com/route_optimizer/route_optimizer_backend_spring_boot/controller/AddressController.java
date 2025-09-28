package com.route_optimizer.route_optimizer_backend_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;
import com.route_optimizer.route_optimizer_backend_spring_boot.service.AddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/addresses")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AddressController {

  private final AddressService addressService;

  @GetMapping("/{customerId}")
  public List<AddressResponse> getAllAddressesByCustomer(@PathVariable Long customerId) {
    return addressService.getAllAddressesByCustomer(customerId);
  }
}
