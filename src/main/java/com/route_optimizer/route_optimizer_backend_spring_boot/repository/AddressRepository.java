package com.route_optimizer.route_optimizer_backend_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
  List<Address> findByCustomerId(Long id);
}
