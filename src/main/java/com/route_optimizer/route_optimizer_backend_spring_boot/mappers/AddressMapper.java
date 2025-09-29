package com.route_optimizer.route_optimizer_backend_spring_boot.mappers;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.AddressDto.CreateAddressDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;

public class AddressMapper {

  public static Address createDtoToEntity(CreateAddressDto createAddressDto, Customer customer) {
    Address address = new Address();

    address.setAddress(createAddressDto.getAddress());
    address.setCity(createAddressDto.getCity());
    address.setDistrict(createAddressDto.getDistrict());
    address.setLatitude(createAddressDto.getLatitude());
    address.setLongitude(createAddressDto.getLongitude());
    address.setCustomer(customer);

    return address;
  }

  public static Address createDtoToEntity(CreateAddressDto createAddressDto) {
    Address address = new Address();

    address.setAddress(createAddressDto.getAddress());
    address.setCity(createAddressDto.getCity());
    address.setDistrict(createAddressDto.getDistrict());
    address.setLatitude(createAddressDto.getLatitude());
    address.setLongitude(createAddressDto.getLongitude());

    return address;
  }

  public static AddressResponse toResponse(Address address) {
    var addressResponse = new AddressResponse();

    addressResponse.setAddress(address.getAddress());
    addressResponse.setCity(address.getCity());
    addressResponse.setDistrict(address.getCity());
    addressResponse.setId(address.getId());
    addressResponse.setLatitude(address.getLatitude());
    addressResponse.setLongitude(address.getLongitude());

    return addressResponse;
  }
}
