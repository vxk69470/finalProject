package com.demo.finalproject.repo;

import java.util.Optional;

import com.demo.finalproject.model.Role;
import com.demo.finalproject.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(Roles role);
}
