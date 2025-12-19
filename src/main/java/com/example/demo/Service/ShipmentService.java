package com.example.demo.service;

import com.example.demo.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment create(Shipment shipment);

    Shipment getById(Long id);

    List<Shipment> getAll();

    }


