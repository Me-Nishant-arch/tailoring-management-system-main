package com.TMS.tailoring_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TMS.tailoring_management.model.Measurements;

public interface MeasurementsRepo extends JpaRepository<Measurements, Long> {
}
