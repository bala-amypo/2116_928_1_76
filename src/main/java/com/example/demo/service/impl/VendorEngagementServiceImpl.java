package com.example.demo.service.impl;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository engagementRepo;
    private final PersonProfileRepository personRepo;

    // ✅ EXACT constructor tests use
    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository engagementRepo,
            PersonProfileRepository personRepo
    ) {
        this.engagementRepo = engagementRepo;
        this.personRepo = personRepo;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        return engagementRepo.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return engagementRepo.findAll();
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return engagementRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return engagementRepo.findByVendorId(vendorId);
    }
}
