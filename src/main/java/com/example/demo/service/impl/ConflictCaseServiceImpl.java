package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository conflictCaseRepository;

    // ✅ REQUIRED CONSTRUCTOR (tests expect this)
    public ConflictCaseServiceImpl(ConflictCaseRepository conflictCaseRepository) {
        this.conflictCaseRepository = conflictCaseRepository;
    }

    @Override
    public ConflictCase save(ConflictCase conflictCase) {
        return conflictCaseRepository.save(conflictCase);
    }

    @Override
    public Optional<ConflictCase> findById(Long id) {
        return conflictCaseRepository.findById(id);
    }

    @Override
    public List<ConflictCase> findAll() {
        return conflictCaseRepository.findAll();
    }
}
