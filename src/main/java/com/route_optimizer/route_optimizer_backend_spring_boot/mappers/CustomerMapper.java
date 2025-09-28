package com.route_optimizer.route_optimizer_backend_spring_boot.mappers;


import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.CreateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.UpdateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;

public class CustomerMapper {

  public static Customer createDtoToEntity(CreateCustomerDto createCustomerDto) {
    Customer customer = new Customer();

    customer.setNombre(createCustomerDto.getNombre());
    customer.setEmail(createCustomerDto.getEmail());
    customer.setTelefono(createCustomerDto.getTelefono());

    return customer;
  }

  public static Customer updateDtoToEntity(Customer customer, UpdateCustomerDto updateCustomerDto) {
    customer.setEmail(updateCustomerDto.getEmail());
    customer.setNombre(updateCustomerDto.getNombre());
    customer.setTelefono(updateCustomerDto.getTelefono());

    return customer;
  }

}
