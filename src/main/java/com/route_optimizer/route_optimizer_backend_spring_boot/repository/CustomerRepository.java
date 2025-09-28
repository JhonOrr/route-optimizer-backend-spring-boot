package com.route_optimizer.route_optimizer_backend_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  List<Customer> findByStatusOrderByIdAsc(Integer status);
}
