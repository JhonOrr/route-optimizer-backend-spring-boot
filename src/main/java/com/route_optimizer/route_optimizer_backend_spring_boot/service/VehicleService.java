package com.route_optimizer.route_optimizer_backend_spring_boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.CreateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.UpdateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Vehicle;
import com.route_optimizer.route_optimizer_backend_spring_boot.mappers.VehicleMapper;
import com.route_optimizer.route_optimizer_backend_spring_boot.repository.VehicleRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  public List<Vehicle> getAllVehicles() {
    return vehicleRepository.findByStatusOrderByIdAsc(1);
  }

  public Vehicle createVehicle(CreateVehicleDto createVehicleDto) {

    Vehicle newVehicle = VehicleMapper.createVehicleDtotoEntity(createVehicleDto);
    newVehicle.setStatus(1);

    return vehicleRepository.save(newVehicle);
  }

  public Vehicle updateVehicle(Long id, UpdateVehicleDto updateVehicleDto) {

    Vehicle vehicle = vehicleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Vehicle not found with id" + id));

    VehicleMapper.updateVehicleDtoToEntity(vehicle, updateVehicleDto);
    return vehicleRepository.save(vehicle);
  }

  public void deleteVehicle(Long id) {

    Vehicle vehicle = vehicleRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Vehicle not found with id" + id));

    vehicle.setStatus(0);

    vehicleRepository.save(vehicle);
  }
}
