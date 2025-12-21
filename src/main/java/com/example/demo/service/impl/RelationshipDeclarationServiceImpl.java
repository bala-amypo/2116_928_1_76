package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.List;

public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repository;
    private final PersonProfileRepository personRepository;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository repository,
            PersonProfileRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {
        personRepository.findById(declaration.getPersonId())
                .orElseThrow(() -> new ApiException("Missing person"));

        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repository.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long declarationId, Boolean verified) {
        RelationshipDeclaration declaration = repository.findById(declarationId)
                .orElseThrow(() -> new ApiException("Missing person"));

        declaration.setVerified(verified);
        return repository.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repository.findAll();
    }
}
