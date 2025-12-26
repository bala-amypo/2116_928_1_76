package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration declare(@RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @GetMapping("/{id}")
    public Optional<RelationshipDeclaration> getById(@PathVariable Long id) {
        return service.getDeclarationById(id);
    }

    @GetMapping
    public List<RelationshipDeclaration> getAll() {
        return service.getAllDeclarations();
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }
}
