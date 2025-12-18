package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResult;

import com.example.demo.entity.Shipment;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.RouteOptimizationResultRepository;

import com.example.demo.repository.ShipmentRepository;

import com.example.demo.service.RouteOptimizationService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.Random;

@Service

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;

    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository shipmentRepo, RouteOptimizationResultRepository resultRepo) {

        this.shipmentRepo = shipmentRepo;

        this.resultRepo = resultRepo;

        }

        @Override

        public RouteOptimizationResult optimize(Long shipmentId) {

            Shipment shipment = shipmentRepo.findById(shipmentId)

            .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

            double distance = new Random().nextDouble(500) + 50;

            double fuelUsage = distance / shipment.getVehicle().getFuelEfficiency();

            RouteOptimizationResult result = new RouteOptimizationResult();

            result.setShipment(shipment);

            result.setEstimatedFuelUsageL(fuelUsage);

            result.setOptimizedDistanceKm(distance);

            result.setGeneratedAt(LocalDateTime.now());

            return resultRepo.save(result);

            }

            }


