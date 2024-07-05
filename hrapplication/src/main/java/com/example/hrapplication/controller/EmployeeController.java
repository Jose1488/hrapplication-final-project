package com.example.hrapplication.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hrapplication.model.Employee;
import com.example.hrapplication.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @GetMapping("/add-employee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute Employee employee) {
        // Set current date upon adding a new employee
        employee.setDateOfAppointment(new Date());
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee/{nationalId}")
    public String editEmployeeForm(@PathVariable String nationalId, Model model) {
        Employee employee = employeeService.getEmployeeByNationalId(nationalId);
        if (employee == null) {
            // Handle case where employee with given nationalId is not found
            return "error";
        }
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/edit-employee")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete-employee/{nationalId}")
    public String deleteEmployee(@PathVariable String nationalId) {
        employeeService.deleteEmployeeByNationalId(nationalId);
        return "redirect:/employees";
    }
}
