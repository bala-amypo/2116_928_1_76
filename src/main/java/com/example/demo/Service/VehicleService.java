package com.example.demo.service;



import com.example.demo.entity.Vehicle;

import java.util.List;



public interface VehicleService {

    Vehicle create(Long userId, Vehicle vehicle);

    Vehicle getById(Long id);

    List<Vehicle> getByUser(Long userId);

}


