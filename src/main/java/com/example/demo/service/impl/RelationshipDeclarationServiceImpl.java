package com.example.demo.service.impl;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repository;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repository) {
        this.repository = repository;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    @Override
    public Optional<RelationshipDeclaration> getDeclarationById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean verified) {
        RelationshipDeclaration declaration =
                repository.findById(id).orElseThrow();
        declaration.setVerified(verified);
        return repository.save(declaration);
    }
}
