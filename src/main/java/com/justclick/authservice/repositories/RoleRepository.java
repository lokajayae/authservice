package com.justclick.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justclick.authservice.domains.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);

}
