package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendor_engagements")
public class VendorEngagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String engagementType;
    private String notes;

    private LocalDate engagementDate;

    @ManyToOne
    private PersonProfile employee;

    @ManyToOne
    private PersonProfile vendor;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEngagementType() {
        return engagementType;
    }

    public void setEngagementType(String engagementType) {
        this.engagementType = engagementType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getEngagementDate() {
        return engagementDate;
    }

    public void setEngagementDate(LocalDate engagementDate) {
        this.engagementDate = engagementDate;
    }

    public PersonProfile getEmployee() {
        return employee;
    }

    public void setEmployee(PersonProfile employee) {
        this.employee = employee;
    }

    public PersonProfile getVendor() {
        return vendor;
    }

    public void setVendor(PersonProfile vendor) {
        this.vendor = vendor;
    }
}
