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
import com.TMS.tailoring_management.service.MeasurementsService;
;

@Controller
public class homeController {
	
	
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private MeasurementsService measurementsService;
	
	
	


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
    @GetMapping("/shop")
    public String getShop() {
    	return "home";
    }
    
    @GetMapping("/measurements")
    public String showMeasurementPage(Model model) {
        // Create a new Measurements object and add it to the model
        model.addAttribute("measurements", new Measurements());
        return "measurements"; // this is your HTML form
    }

    @GetMapping("/submitMeasurements")
    public String getMeasurementsFormPage(){
    	return "measurements-form";
    }
    @PostMapping("/submitMeasurements")
    public String submitMeasurements(@ModelAttribute Measurements measurements) {
        // Save the measurements
        measurementsService.save(measurements);
        return "redirect:/confirmation"; // Redirect to a confirmation page or success page
    }
    @GetMapping("/confirmation")
    public String getConformationPage(){
    	return "confirmation";
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

        // Check if the phone number already exists
        if (appointmentService.isPhoneNumberAlreadyExists(appointment.getPhoneNumber())) {
            result.rejectValue("phoneNumber", "error.phoneNumber", "An appointment with this phone number already exists.");
        }
        
        // If there are validation errors, return to the form with error messages
        if (result.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.appointment", result);
            return "appointment-form"; // Stay on the form if there are validation errors
        }
        try {
            appointmentService.saveAppointment(appointment); // Save the appointment to the database
            model.addAttribute("message", "Appointment successfully made! Please return to home");
        } catch (Exception e) {
            e.printStackTrace(); // Log the error to the console
            model.addAttribute("error", "Failed to make appointment. Please try again.");
        }

        return "appointment-form"; // Stay on the appointment form to display the success/error message
    }


}

    
  
