package com.route_optimizer.route_optimizer_backend_spring_boot.mappers;

import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.CreateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.dto.vehicleDto.UpdateVehicleDto;
import com.route_optimizer.route_optimizer_backend_spring_boot.entity.Vehicle;

public class VehicleMapper {
  public static Vehicle createVehicleDtotoEntity(CreateVehicleDto createVehicleDto) {
    Vehicle vehicle = new Vehicle();

    vehicle.setPlaca(createVehicleDto.getPlaca());
    vehicle.setMarca(createVehicleDto.getMarca());
    vehicle.setModelo(createVehicleDto.getModelo());
    vehicle.setCapacity(createVehicleDto.getCapacity());

    return vehicle;
  }

  public static Vehicle updateVehicleDtoToEntity(Vehicle vehicle, UpdateVehicleDto updateVehicleDto) {
    
    vehicle.setPlaca(updateVehicleDto.getPlaca());
    vehicle.setMarca(updateVehicleDto.getMarca());
    vehicle.setModelo(updateVehicleDto.getModelo());
    vehicle.setCapacity(updateVehicleDto.getCapacity());

    return vehicle;
  }

}
