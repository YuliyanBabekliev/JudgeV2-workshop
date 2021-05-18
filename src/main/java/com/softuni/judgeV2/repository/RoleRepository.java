package com.softuni.judgeV2.repository;

import com.softuni.judgeV2.models.entities.Role;
import com.softuni.judgeV2.models.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
