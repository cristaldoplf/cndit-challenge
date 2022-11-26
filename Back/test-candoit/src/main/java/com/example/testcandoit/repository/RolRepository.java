package com.example.testcandoit.repository;

import com.example.testcandoit.model.entity.Rol;
import com.example.testcandoit.model.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByRolName(RolName rolName);
}
