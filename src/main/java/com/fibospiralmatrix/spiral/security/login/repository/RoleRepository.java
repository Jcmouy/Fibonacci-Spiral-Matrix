package com.fibospiralmatrix.spiral.security.login.repository;

import com.fibospiralmatrix.spiral.security.login.entity.Role;
import com.fibospiralmatrix.spiral.security.login.entity.URole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(URole name);
}
