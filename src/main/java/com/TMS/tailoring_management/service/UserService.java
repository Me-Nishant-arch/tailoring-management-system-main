package com.TMS.tailoring_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TMS.tailoring_management.model.Customer;
import com.TMS.tailoring_management.repository.UserRepository;

import jakarta.transaction.Transactional;



@Service
public class UserService {

	 @Autowired
	  private UserRepository userRepository;  // Repository to access DB

	 public List<Customer> getAllCustomers() {
	        return userRepository.findAll();
	    }
	 

	// Save the updated customer data to the database
	 public void updateUser(Customer customer) {
		    userRepository.save(customer);  
		}

	

	// Method to get a customer by ID
	    public Customer getCustomerById(Long id) {
	        Optional<Customer> customer = userRepository.findById(id);
	        return customer.orElse(null);  // Return the customer if found, else null
	    }

	    // Method to delete a customer
	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);  // Delete customer by ID from the database
	    }
}