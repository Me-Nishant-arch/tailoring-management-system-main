package com.TMS.tailoring_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TMS.tailoring_management.model.Appointment;
import com.TMS.tailoring_management.model.Users;
import com.TMS.tailoring_management.service.AppointmentService;
import com.TMS.tailoring_management.service.UsersService;

@Controller
public class adminHomeController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AppointmentService appointmentService;

    // Admin Home Page
    @GetMapping("/adminHome")
    public String getAdminHomePage() {
        return "/admin/adminHome";
    }

    // Admin Orders Page
    @GetMapping("/adminHome/orders")
    public String getAdminHomeOrdersPage() {
        return "/admin/order";
    }

    // Display all users
    @GetMapping("/adminHome/users")
    public String getAdminHomeUsers(Model model) {
        List<Users> users = usersService.getAllUsers(); // Fetch all users from DB
        model.addAttribute("users", users); // Pass data to view
        return "/admin/usersList"; // Render the user list view
    }

    // Delete a user
    @GetMapping("/adminHome/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            usersService.deleteUserById(id); // Delete the user from the database
            redirectAttributes.addFlashAttribute("message", "User deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete the user.");
        }
        return "redirect:/adminHome/users"; // Redirect to the user list page
    }

    // Display all appointments
    @GetMapping("/adminHome/appointments")
    public String getAdminAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments(); // Fetch all appointments from DB
        model.addAttribute("appointments", appointments); // Pass data to view
        return "/admin/appointmentsList"; // Render the appointments list view
    }

    // Delete an appointment
    @GetMapping("/adminHome/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            appointmentService.deleteAppointment(id); // Delete the appointment from the database
            redirectAttributes.addFlashAttribute("message", "Appointment deleted successfully.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete the appointment.");
        }
        return "redirect:/adminHome/appointments"; // Redirect to the appointments list page
    }
}
