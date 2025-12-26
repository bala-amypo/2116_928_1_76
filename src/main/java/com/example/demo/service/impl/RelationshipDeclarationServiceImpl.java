package com.example.demo.service.impl;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repository;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository repository) {
        this.repository = repository;
    }

    @Override
    public RelationshipDeclaration create(RelationshipDeclaration declaration) {
        return repository.save(declaration);
    }

    @Override
    public RelationshipDeclaration getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RelationshipDeclaration> getByPersonId(Long personId) {
        return repository.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verify(Long id, boolean verified) {
        RelationshipDeclaration rd = getById(id);
        if (rd != null) {
            rd.setVerified(verified);
            return repository.save(rd);
        }
        return null;
    }
}
