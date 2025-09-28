package com.route_optimizer.route_optimizer_backend_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Vehicle;

import java.util.List;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findByStatusOrderByIdAsc(Integer status);
}
