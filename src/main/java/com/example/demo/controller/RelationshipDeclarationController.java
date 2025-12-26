package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration create(@RequestBody RelationshipDeclaration declaration) {
        return service.create(declaration);
    }

    @GetMapping("/{id}")
    public RelationshipDeclaration getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(@PathVariable Long personId) {
        return service.getByPersonId(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified
    ) {
        return service.verify(id, verified);
    }
}
