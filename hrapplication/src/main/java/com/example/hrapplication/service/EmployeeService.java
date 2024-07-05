package com.example.hrapplication.service;

import java.util.List;

import com.example.hrapplication.model.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void deleteEmployeeByNationalId(String nationalId);
    void updateEmployee(Employee updatedEmployee);
    Employee getEmployeeByNationalId(String nationalId);
}

