package com.route_optimizer.route_optimizer_backend_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Order;
import java.util.List;


public interface OrderRepository extends JpaRepository<Order, Long> {
  List<Order> findByStatus(String status);
}
