package com.gestionStudent.gestionStudent.repository;

import com.gestionStudent.gestionStudent.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleName(String roleName);
}
