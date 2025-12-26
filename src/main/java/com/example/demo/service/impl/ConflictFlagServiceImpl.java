package com.example.demo.service.impl;

import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository conflictFlagRepository;

    public ConflictFlagServiceImpl(ConflictFlagRepository conflictFlagRepository) {
        this.conflictFlagRepository = conflictFlagRepository;
    }

    @Override
    public ConflictFlag save(ConflictFlag flag) {
        return conflictFlagRepository.save(flag);
    }

    @Override
    public Optional<ConflictFlag> findById(Long id) {
        return conflictFlagRepository.findById(id);
    }

    @Override
    public List<ConflictFlag> findAll() {
        return conflictFlagRepository.findAll();
    }
}
