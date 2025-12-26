package com.example.demo.service.impl;

import com.example.demo.model.VendorEngagement;
import com.example.demo.repository.VendorEngagementRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRepository vendorEngagementRepository;
    private final PersonProfileRepository personProfileRepository;

    // ✅ TEST EXPECTS THIS CONSTRUCTOR
    public VendorEngagementServiceImpl(
            VendorEngagementRepository vendorEngagementRepository,
            PersonProfileRepository personProfileRepository
    ) {
        this.vendorEngagementRepository = vendorEngagementRepository;
        this.personProfileRepository = personProfileRepository;
    }

    @Override
    public VendorEngagement save(VendorEngagement engagement) {
        return vendorEngagementRepository.save(engagement);
    }

    @Override
    public Optional<VendorEngagement> findById(Long id) {
        return vendorEngagementRepository.findById(id);
    }

    @Override
    public List<VendorEngagement> findAll() {
        return vendorEngagementRepository.findAll();
    }
}
