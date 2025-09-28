package com.route_optimizer.route_optimizer_backend_spring_boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.CreateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.UpdateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Vehicle;
import com.route_optimizer.route_optimizer_backend_spring_boot.service.VehicleService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/vehicles")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class VehicleController {

  private final VehicleService vehicleService;

  @PostMapping
  public Vehicle createVehicle(@RequestBody CreateVehicleDto createVehicleDto) {
    return vehicleService.createVehicle(createVehicleDto);
  }

  @GetMapping
  public List<Vehicle> getAllVehicles() {
    return vehicleService.getAllVehicles();
  }

  @PutMapping("/{id}")
  public Vehicle updateVehicle(@PathVariable Long id, @RequestBody UpdateVehicleDto updateVehicleDto) {
    return vehicleService.updateVehicle(id, updateVehicleDto);
  }

  @DeleteMapping("/{id}")
  public void deleteVehicle(@PathVariable Long id) {
    vehicleService.deleteVehicle(id);
  }
}
