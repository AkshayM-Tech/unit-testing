package com.ak.service.impl;

import com.ak.exception.ResourceNotFoundException;
import com.ak.model.Employee;
import com.ak.repository.EmployeeRepository;
import com.ak.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository){
        this.repository = repository;
        System.err.println("Instantiated EmployeeService...");
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        Employee existingEmployee = repository.findByEmail(employee.getEmail());

        if (null != existingEmployee)
            throw new ResourceNotFoundException("Employee already exists with given email : "+employee.getEmail());
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(long empId) {
        Optional<Employee> optionalEmployee = repository.findById(empId);

        if (optionalEmployee.isEmpty())
            throw new ResourceNotFoundException("Employee does not exist for given Id : "+empId);
        return optionalEmployee.get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = repository.findById(employee.getId());
        if (optionalEmployee.isEmpty())
            throw new ResourceNotFoundException("Employee does not exist from given Id : "+employee.getId());
        return repository.save(employee);
    }

    @Override
    public void deleteEmployee(long empId) {
        Optional<Employee> optionalEmployee = repository.findById(empId);
        if (optionalEmployee.isEmpty())
            throw new ResourceNotFoundException("Employee does not exist from given Id : "+empId);

        repository.deleteById(empId);
    }
}
