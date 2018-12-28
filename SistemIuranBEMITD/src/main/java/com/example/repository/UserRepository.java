package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);

    Optional<User> findById(Long id);
}
