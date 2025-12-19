package com.example.demo.controller;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
private final VehicleService service;

public VehicleController(VehicleService service) {
this.service = service;
}

@PostMapping("/register/{userId}")
public Vehicle registerVehicle(@PathVariable Long userId,@RequestBody Vehicle vehicle) {
return service.create(userId, vehicle);
}

@GetMapping("/{vehicleId}")
public Vehicle getVehicle(@PathVariable Long vehicleId) {
return service.getById(vehicleId);
}

@GetMapping("/user/{userId}")
public List<Vehicle> getVehiclesByUser(@PathVariable Long userId) {
return service.getByUser(userId);
}
}
