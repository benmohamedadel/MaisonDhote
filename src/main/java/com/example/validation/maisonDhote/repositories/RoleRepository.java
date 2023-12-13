package com.example.validation.maisonDhote.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validation.maisonDhote.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
   Role findByRole(String role);

}
