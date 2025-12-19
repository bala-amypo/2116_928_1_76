package com.example.demo.entity;



import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;



@Data

@Entity

@Table(name = "route_results")

public class RouteOptimizationResult {



    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @ManyToOne

    private Shipment shipment;



    private Double optimizedDistanceKm;



    private Double estimatedFuelUsageL;



    private LocalDateTime generatedAt;

    }

    
}