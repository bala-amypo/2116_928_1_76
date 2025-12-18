package com.example.demo.service.impl;

import com.example.demo.entity.User;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.repository.UserRepository;

import com.example.demo.service.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository repo) {

        this.repo = repo;

    }

    @Override

    public User register(User user) {

        if (user.getPassword() == null || user.getPassword().isEmpty()) {

            throw new IllegalArgumentException("Password cannot be empty");

            }

            user.setPassword(encoder.encode(user.getPassword()));

            if (user.getRole() == null || user.getRole().isEmpty()) {

                user.setRole("USER");

                }

                return repo.save(user);

                }

                @Override

                public User findById(Long id) {

                    return repo.findById(id)

                    .orElseThrow(() -> new ResourceNotFoundException("User not found"));

                    }

                    @Override

                    public User findByEmail(String email) {

                        return repo.findByEmail(email);

                        }

        
        }
    