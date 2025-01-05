package com.TMS.tailoring_management.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.TMS.tailoring_management.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmailOrUsername(String email, String username);
}
