package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "conflict_cases")
public class ConflictCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String statusCode;
    private String riskLevel;
    private String triggerSource;

    private LocalDateTime detectedAt = LocalDateTime.now();

    @ManyToOne
    private PersonProfile primaryPerson;

    @ManyToOne
    private PersonProfile secondaryPerson;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getTriggerSource() {
        return triggerSource;
    }

    public void setTriggerSource(String triggerSource) {
        this.triggerSource = triggerSource;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public PersonProfile getPrimaryPerson() {
        return primaryPerson;
    }

    public void setPrimaryPerson(PersonProfile primaryPerson) {
        this.primaryPerson = primaryPerson;
    }

    public PersonProfile getSecondaryPerson() {
        return secondaryPerson;
    }

    public void setSecondaryPerson(PersonProfile secondaryPerson) {
        this.secondaryPerson = secondaryPerson;
    }
}
