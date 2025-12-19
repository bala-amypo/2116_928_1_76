package com.example.demo.service.impl;

import com.example.demo.entity.Location;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.LocationRepository;

import com.example.demo.service.LocationService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {

        this.repo = repo;

        }

        @Override

        public Location create(Location location) {

            if (location.getLatitude() > 90 || location.getLatitude() < -90) {

                throw new IllegalArgumentException("Invalid latitude");

                }

                return repo.save(location);

                }

                @Override

                public Location getById(Long id) {

                    return repo.findById(id)

                    .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

                    }

                    @Override

                    public List<Location> getAll() {

                        return repo.findAll();

                        }

                        }
    