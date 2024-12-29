package com.TMS.tailoring_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import com.TMS.tailoring_management.model.Appointment;
import com.TMS.tailoring_management.model.Customer;
import com.TMS.tailoring_management.service.AppointmentService;
import com.TMS.tailoring_management.service.UserService;

@Controller
public class adminHomeController {
	
	
	@Autowired
	private UserService userService;  // Service class that handles DB interaction
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	@GetMapping("/adminHome")
	public String getAdminHomePage() {
		return "/admin/adminHome";
	}
	
	@GetMapping("/adminHome/orders")
	public String getAdminHomeOrdersPage() {
		return "/admin/order";
	}
	

	  // Method to display all the Users in List
	@GetMapping("/adminHome/users")
	public String getAdminHomeUsers(Model model) {
		 List<Customer> users = userService.getAllCustomers(); // Fetch data from DB
	        model.addAttribute("users", users);  // Add data to model to pass it to the view
	        return "/admin/usersList";  
	}
   // Method to handle Delete request
    @GetMapping("/adminHome/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);  // Delete the user from the database
        return "redirect:/adminHome/users	";  // Redirect back to the user list
    }
    
    // Method to display all the appointments in List
    @GetMapping("/adminHome/appointments")
    public String getAdminAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments(); // Fetch appointments from DB
        model.addAttribute("appointments", appointments);  // Add data to model to pass it to the view
        return "/admin/appointmentsList";  // Return the view for appointments list
    }
    // Method to handle Delete request
    @GetMapping("/adminHome/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentService.deleteAppointment(id);  // Delete the user from the database
        return "redirect:/adminHome/appointments	";  
    }
    
    
    
}
