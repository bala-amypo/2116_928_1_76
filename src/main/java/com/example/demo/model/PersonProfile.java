package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_profiles")
public class PersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String referenceId;

    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;
    private String department;
    private String personType;
    private boolean relationshipDeclared;

    private LocalDateTime createdAt = LocalDateTime.now();

    // ---------- GETTERS & SETTERS ----------

    public Long getId() {
        return id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public boolean isRelationshipDeclared() {
        return relationshipDeclared;
    }

    public void setRelationshipDeclared(boolean relationshipDeclared) {
        this.relationshipDeclared = relationshipDeclared;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
