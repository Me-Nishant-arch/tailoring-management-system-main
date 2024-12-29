package com.TMS.tailoring_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.TMS.tailoring_management.model.Appointment;
import com.TMS.tailoring_management.model.Measurements;
import com.TMS.tailoring_management.service.AppointmentService;
import com.TMS.tailoring_management.service.CustomerService;

@Controller
public class homeController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	


    @GetMapping("/contact")
    public String getContactpage() {
        return "contact";
    }
    @GetMapping("/home")
    public String getHomepage() {
        return "home";
    }
    @GetMapping("/login")
    public String getLoginPage() {
    	return "login";
    }
    @GetMapping("/aboutUs")
    public String getAboutUs() {
    	return "aboutUs";
    }
    @GetMapping("/collection")
    public String getCollection() {
    	return "collection";
    }
    
    
    
    @GetMapping("/measurements")
    public String getMeasurementsPage(Model model) {
    	model.addAttribute("measure",new Measurements());
    	return "measurements";
    }
  
    
    
    
    
    
    @GetMapping("/appointments")
    public String getAppointmentsPage(Model model) {
        model.addAttribute("appointment", new Appointment());  // Initialize a new Appointment object
        return "appointment-form";  // View for the appointment form
    }
    
    @PostMapping("/appointments")
    public String postAppointmentForm(@ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        // Check if the email already exists before processing the form
        if (appointmentService.isEmailAlreadyExists(appointment.getEmail())) {
            result.rejectValue("email", "error.email", "An appointment with this email already exists.");
        }

        // If there are validation errors, return to the form with error messages
        if (result.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.appointment", result);
            return "appointment-form";  // Stay on the form if there are validation errors
        }

        try {
            appointmentService.saveAppointment(appointment);  // Save the appointment to the database
            model.addAttribute("message", "Appointment successfully made!");
            return "redirect:/home";  // Redirect to the home page after successful appointment
        } catch (Exception e) {
            e.printStackTrace();  // Log the error to the console
            model.addAttribute("error", "Failed to make appointment. Please try again.");
            return "appointment-form";  // Stay on the appointment form if there's an error
        }
    }

}

    
  
