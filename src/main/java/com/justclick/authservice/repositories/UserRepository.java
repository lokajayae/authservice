package com.justclick.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justclick.authservice.domains.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
