package com.route_optimizer.route_optimizer_backend_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.CreateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.UpdateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {
  private final CustomerService customerService;

  @PostMapping
  public Customer createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
    return customerService.createCustomer(createCustomerDto);
  }

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @PutMapping("/{id}")
  public Customer updateCustomer(@RequestBody UpdateCustomerDto updateCustomerDto, @PathVariable Long id) {
    return customerService.updateCustomer(updateCustomerDto, id);
  }

  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }
}
