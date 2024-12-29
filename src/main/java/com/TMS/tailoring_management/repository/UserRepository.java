package com.TMS.tailoring_management.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TMS.tailoring_management.model.Customer;

public interface UserRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}