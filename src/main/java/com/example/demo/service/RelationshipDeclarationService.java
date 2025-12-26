package com.example.demo.service;

import com.example.demo.model.RelationshipDeclaration;

import java.util.List;

public interface RelationshipDeclarationService {

    RelationshipDeclaration create(RelationshipDeclaration declaration);

    RelationshipDeclaration getById(Long id);

    List<RelationshipDeclaration> getByPersonId(Long personId);

    RelationshipDeclaration verify(Long id, boolean verified);
}
