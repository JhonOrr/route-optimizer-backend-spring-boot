package com.route_optimizer.route_optimizer_backend_spring_boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.OrderDto.CreateOrderDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Order;
import com.route_optimizer.route_optimizer_backend_spring_boot.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public List<Order> getAllOrders(){
    return orderService.getAllOrders();
  }

  @PostMapping
  public Order createOrder(@RequestBody CreateOrderDto createOrderDto) {
    return orderService.createOrder(createOrderDto);
  }
}
