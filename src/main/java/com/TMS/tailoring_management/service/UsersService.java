package com.TMS.tailoring_management.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.TMS.tailoring_management.model.Users;
import com.TMS.tailoring_management.repository.UsersRepository;


@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users getLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String usernameOrEmail = ((UserDetails) principal).getUsername();
            return usersRepository.findByEmailOrUsername(usernameOrEmail, usernameOrEmail)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }
        throw new RuntimeException("Unauthenticated access");
    }

    public Users saveUsers(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }

    public Users findByEmailOrUsername(String input) {
        return usersRepository.findByEmailOrUsername(input, input)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean doesUserExist(String emailOrUsername) {
        return usersRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername).isPresent();
    }

    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(Long id) {
        return usersRepository.findById(id);
    }
}


