package com.ak.service;

import com.ak.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long empId);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long empId);
}
