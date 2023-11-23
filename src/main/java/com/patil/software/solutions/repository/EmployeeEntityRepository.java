package com.patil.software.solutions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patil.software.solutions.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {
}
