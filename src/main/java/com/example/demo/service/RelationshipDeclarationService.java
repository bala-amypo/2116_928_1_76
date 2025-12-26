package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relationship_declarations")
public class RelationshipDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relationshipType;
    private String relatedPersonName;
    private String description;
    private boolean verified;
    private LocalDateTime declaredAt;

    @ManyToOne
    private PersonProfile person;

    public RelationshipDeclaration() {}

    public Long getId() {
        return id;
    }

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }

    public String getRelatedPersonName() {
        return relatedPersonName;
    }

    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ✅ TESTS REQUIRE BOTH getVerified() AND isVerified()
    public boolean isVerified() {
        return verified;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getDeclaredAt() {
        return declaredAt;
    }

    public void setDeclaredAt(LocalDateTime declaredAt) {
        this.declaredAt = declaredAt;
    }

    public PersonProfile getPerson() {
        return person;
    }

    public void setPerson(PersonProfile person) {
        this.person = person;
    }
}
