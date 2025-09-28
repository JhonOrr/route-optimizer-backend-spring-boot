package com.route_optimizer.route_optimizer_backend_spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.OrderDto.CreateOrderDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Order;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.AddressRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.CustomerRepository;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final AddressRepository AddressRepository;
  private final CustomerRepository customerRepository;

  public List<Order> getAllOrders(){
    return orderRepository.findAll();
  }

  public Order createOrder(CreateOrderDto createOrderDto) {

    Customer customer = customerRepository.findById(createOrderDto.getCustomerId())
        .orElseThrow(() -> new RuntimeException("Customer not found"));

    Address address = AddressRepository.findById(createOrderDto.getAddressId())
        .orElseThrow(() -> new RuntimeException("Address not found"));

    Order order = new Order();
    
    order.setAddress(address);
    order.setCustomer(customer);
    order.setOrderDate(createOrderDto.getOrderDate());
    order.setStatus(1);
    order.setWeight(createOrderDto.getWeight());
    order.setOrderNumber("x");

    order = orderRepository.save(order);



    order.setOrderNumber(createOrderDto.getOrderDate().getYear() + "-" + order.getId());
    order = orderRepository.save(order);

    return order;


  }

}
