package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;

import java.util.List;
import java.util.Optional;

public interface RelationshipDeclarationService {

    RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration);

    List<RelationshipDeclaration> getAllDeclarations();

    Optional<RelationshipDeclaration> getDeclarationById(Long id);

    RelationshipDeclaration verifyDeclaration(Long id, boolean verified);
}
