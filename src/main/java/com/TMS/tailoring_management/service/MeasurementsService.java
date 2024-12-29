package com.TMS.tailoring_management.service;

import com.TMS.tailoring_management.model.Measurements;
import com.TMS.tailoring_management.repository.MeasurementsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementsService {

    @Autowired
    private MeasurementsRepo measurementsRepository;

    public void save(Measurements measurements) {
        measurementsRepository.save(measurements);
    }
}
