package com.example.hrapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrapplication.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByNationalId(String nationalId);
    void deleteByNationalId(String nationalId);
}