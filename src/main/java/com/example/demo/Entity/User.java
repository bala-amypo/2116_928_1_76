package com.example.demo.entity;



import jakarta.persistence.*;

import lombok.Data;



@Data

@Entity

@Table(

    name = "users",

    uniqueConstraints = @UniqueConstraint(columnNames = "email")

    )

    public class User {



        @Id

        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;



        private String name;



        @Column(nullable = false)

        private String email;



        private String password;



        private String role;

        }

        
    }