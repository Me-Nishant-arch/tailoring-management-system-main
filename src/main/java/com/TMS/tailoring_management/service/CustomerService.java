package com.TMS.tailoring_management.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.TMS.tailoring_management.model.Customer;
import com.TMS.tailoring_management.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    
   
    public Customer saveCustomer(Customer customer) {
        // Encode the password before saving
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    
    public boolean isEmailAlreadyExists(String email) {
        return customerRepository.findByEmail(email).isPresent();
    }
    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email)
            .orElse(null);
    }
}

   
