package com.route_optimizer.route_optimizer_backend_spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto.CreateAddressDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.CreateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.CustomerDto.UpdateCustomerDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.mappers.CustomerMapper;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.CustomerRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.CustomerResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final AddressService addressService;

  public List<CustomerResponse> getAllCustomers() {
    List<Customer> customers = customerRepository.findByStatusOrderByIdAsc(1);

    return customers.stream().map((customer) -> {
      List<AddressResponse> addresses = addressService.getAllAddressesByCustomer(customer.getId());
      return CustomerMapper.toResponse(customer, addresses);
    }).toList();
  }

  public Customer createCustomer(CreateCustomerDto createCustomerDto) {

    Customer newCustomer = CustomerMapper.createDtoToEntity(createCustomerDto);
    newCustomer.setStatus(1);
    Customer customerSaved = customerRepository.save(newCustomer);

    for(CreateAddressDto address : createCustomerDto.getAddresses()){
      addressService.createAddress(address, customerSaved);
    }

    return customerSaved;
  }

  public Customer updateCustomer(UpdateCustomerDto updateCustomerDto, Long id) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found with id" + id));

    CustomerMapper.updateDtoToEntity(customer, updateCustomerDto);
    return customerRepository.save(customer);
  }

  public void deleteCustomer(Long id) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found with id" + id));

    customer.setStatus(0);
    customerRepository.save(customer);
  }

}
