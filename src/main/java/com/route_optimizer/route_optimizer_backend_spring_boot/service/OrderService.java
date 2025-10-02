package com.route_optimizer.route_optimizer_backend_spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.OrderDto.CreateOrderDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Order;
import com.route_optimizer.route_optimizer_backend_spring_boot.mappers.AddressMapper;
import com.route_optimizer.route_optimizer_backend_spring_boot.mappers.OrderMapper;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.AddressRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.CustomerRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.OrderRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.AddressResponse;
import com.route_optimizer.route_optimizer_backend_spring_boot.response.OrderResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final AddressRepository addressRepository;
  private final CustomerRepository customerRepository;

  public List<OrderResponse> getAllOrders() {
    List<Order> orders = orderRepository.findAll();

    return orders.stream().map(order -> {
      AddressResponse pickupAddress = AddressMapper.toResponse(order.getPickupAddress());
      AddressResponse deliveryAddress = AddressMapper.toResponse(order.getDeliveryAddress());

      return OrderMapper.toResponse(order, deliveryAddress, pickupAddress);
    }).toList();
  }

  public Order createOrder(CreateOrderDto createOrderDto) {

    Customer customer = customerRepository.findById(createOrderDto.getCustomerId())
        .orElseThrow(() -> new RuntimeException("Customer not found"));

    Address pickupAddress = addressRepository.findById(createOrderDto.getPickupAddressId())
        .orElseThrow(() -> new RuntimeException("Address not found"));

    Address deliveryAddress = AddressMapper.createDtoToEntity(createOrderDto.getDeliveryAddress());

    deliveryAddress = addressRepository.save(deliveryAddress);

    Order order = new Order();

    order.setPickupAddress(pickupAddress);
    order.setDeliveryAddress(deliveryAddress);
    order.setCustomer(customer);
    order.setOrderDate(createOrderDto.getOrderDate());
    order.setStatus("1");
    order.setWeight(createOrderDto.getWeight());
    order.setOrderNumber("x");

    order = orderRepository.save(order);
    order.setOrderNumber(createOrderDto.getOrderDate().getYear() + "-" + order.getId());
    order = orderRepository.save(order);

    return order;
  }

}
