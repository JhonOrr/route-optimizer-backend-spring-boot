package com.route_optimizer.route_optimizer_backend_spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto.CreateAddressDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.mappers.AddressMapper;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.AddressRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;

  public Address createAddress(CreateAddressDto createAddressDto, Customer customer) {

    Address newAddress = AddressMapper.createDtoToEntity(createAddressDto, customer);
    return addressRepository.save(newAddress);
  }

  public List<AddressResponse> getAllAddressesByCustomer(Long id) {
    return addressRepository.findByCustomerId(id).stream().map(AddressMapper::toResponse).toList();
  }
}
