package com.example.hrapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hrapplication.model.Employee;
import com.example.hrapplication.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByNationalId(String nationalId) {
        return employeeRepository.findByNationalId(nationalId);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee) {
        employeeRepository.save(updatedEmployee);
    }

    @Override
    @Transactional
    public void deleteEmployeeByNationalId(String nationalId) {
        employeeRepository.deleteByNationalId(nationalId);
    }
}
