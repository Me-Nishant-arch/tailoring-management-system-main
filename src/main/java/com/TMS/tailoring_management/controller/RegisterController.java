package com.TMS.tailoring_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TMS.tailoring_management.model.Customer;
import com.TMS.tailoring_management.security.SecurityConfig;
import com.TMS.tailoring_management.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	
    @Autowired
    private CustomerService customerService;
 
    @GetMapping("/register")
    public String getRegister(Model model) {
        // If model doesn't already contain customer, add it
        if (!model.containsAttribute("customer")) {
            model.addAttribute("customer", new Customer());
        }
        return "register-form";
    }
   
    
    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("customer") Customer saveCustomer, 
                                   BindingResult result, 
                                   Model model,
                                   RedirectAttributes redirectAttributes) {
        // Check for standard validation errors
        if (result.hasErrors()) {
            // Add the binding result to the model so error messages can be displayed
            model.addAttribute("org.springframework.validation.BindingResult.customer", result);
            return "register-form";
        }

        // Custom password matching validation
        if (!saveCustomer.isPasswordMatching()) {
            result.rejectValue("confirmPassword", "error.customer", "Passwords do not match");
            return "register-form";
        }

        // Check if email already exists
        if (customerService.isEmailAlreadyExists(saveCustomer.getEmail())) {
            result.rejectValue("email", "error.customer", "An account with this email already exists");
            return "register-form";
        }

        try {
            // Save customer to the database
            customerService.saveCustomer(saveCustomer);
            
            // Add success message for login page
            redirectAttributes.addFlashAttribute("message", "Registration successful! Please login.");
            return "redirect:/login";
        } catch (Exception e) {
            // Handle any unexpected errors during registration
            model.addAttribute("error", "Registration failed. Please try again.");
            return "register-form";
        }
    }

  
}