package com.TMS.tailoring_management.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TMS.tailoring_management.model.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
	
	public List<Appointment> findByEmail(String email);
	
	 boolean existsByPhoneNumber(String phoneNumber);
	 
	

}
