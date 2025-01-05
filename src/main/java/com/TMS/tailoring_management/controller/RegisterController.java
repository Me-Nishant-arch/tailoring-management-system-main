package com.TMS.tailoring_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.TMS.tailoring_management.model.Users;
import com.TMS.tailoring_management.service.UsersService;

import jakarta.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/register")
    public String getRegister(Model model) {
        if (!model.containsAttribute("users")) {
            model.addAttribute("users", new Users());
        }
        return "register-form";
    }

    @PostMapping("/register")
    public String postRegisterForm(@Valid @ModelAttribute("users") Users saveUsers, 
                                   BindingResult result, 
                                   Model model,
                                   RedirectAttributes redirectAttributes) {

        // Validate form fields
        if (result.hasErrors()) {
            model.addAttribute("org.springframework.validation.BindingResult.users", result);
            return "register-form";
        }

        // Validate password confirmation
        if (!saveUsers.isPasswordMatching()) {
            result.rejectValue("confirmPassword", "error.customer", "Passwords do not match");
            return "register-form";
        }

        // Check if email or username already exists
        if (usersService.doesUserExist(saveUsers.getEmail())) {
            result.rejectValue("email", "error.customer", "An account with this email already exists");
            return "register-form";
        }
        if (usersService.doesUserExist(saveUsers.getUsername())) {
            result.rejectValue("username", "error.customer", "An account with this username already exists");
            return "register-form";
        }

        // Save user and handle exceptions
        try {
            usersService.saveUsers(saveUsers);
            redirectAttributes.addFlashAttribute("message", "Registration successful! Please login.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "register-form";
        }
    }
}
