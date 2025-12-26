package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;
import java.util.List;
import java.util.Optional;

public interface RelationshipDeclarationService {

    RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration);

    Optional<RelationshipDeclaration> getDeclarationById(Long id);

    List<RelationshipDeclaration> getAllDeclarations();

    RelationshipDeclaration verifyDeclaration(Long id, boolean verified);
}
