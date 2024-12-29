package com.TMS.tailoring_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TMS.tailoring_management.model.Appointment;
import com.TMS.tailoring_management.repository.AppointmentRepo;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepository;

    public void saveAppointment(Appointment appointment) {
        if (isEmailAlreadyExists(appointment.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        try {
            appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save appointment", e);
        }
    }


    // Method to fetch all appointments from the database
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();  // This returns a list of all appointments
    }

    // Check if email already exists
    public boolean isEmailAlreadyExists(String email) {
        List<Appointment> appointments = appointmentRepository.findByEmail(email);
        return !appointments.isEmpty();  // If any appointments are found, the email exists
    }
    

    // Method to delete Appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);  // Delete appointment by ID from the database
    }

}
