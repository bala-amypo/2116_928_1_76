package com.example.demo.service.impl;

import com.example.demo.entity.Shipment;

import com.example.demo.entity.Vehicle;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.ShipmentRepository;

import com.example.demo.repository.VehicleRepository;

import com.example.demo.service.ShipmentService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

@Service

public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repo;

    private final VehicleRepository vehicleRepo;

    public ShipmentServiceImpl(ShipmentRepository repo, VehicleRepository vehicleRepo) {

        this.repo = repo;

        this.vehicleRepo = vehicleRepo;

        }

        @Override

        public Shipment create(Shipment shipment) {

            Vehicle vehicle = vehicleRepo.findById(shipment.getVehicle().getId())

            .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

            if (shipment.getWeightKg() > vehicle.getCapacityKg()) {

                throw new IllegalArgumentException("Weight exceeds vehicle capacity");

                }

                if (shipment.getScheduledDate().isBefore(LocalDate.now())) {

                    throw new IllegalArgumentException("Date cannot be in the past");

                    }

                    return repo.save(shipment);

                    }

                    @Override

                    public Shipment getById(Long id) {

                        return repo.findById(id)

                        .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

                        }

                        @Override

                        public List<Shipment> getAll() {

                            return repo.findAll();

                            }

                            }


