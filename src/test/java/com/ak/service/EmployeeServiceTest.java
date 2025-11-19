package com.ak.service;

import com.ak.model.Employee;
import com.ak.repository.EmployeeRepository;
import com.ak.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class EmployeeServiceTest {

    private EmployeeRepository repository;
    private EmployeeService service;
    private Employee employee;

    @BeforeEach
    public void setUp(){
        repository = Mockito.mock(EmployeeRepository.class);
        service = new EmployeeServiceImpl(repository);
        employee = Employee.builder()
                .firstName("AKshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
    }

    // Unit test for save employee operation
    @Test
    @DisplayName("Unit test for save employee")
    public void givenEmployee_whenSaveEmployee_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findByEmail(employee.getEmail())).thenReturn(null);
        Mockito.when(repository.save(employee)).thenReturn(employee);

        // When - Action or behaviour that we are going to test
        Employee savedEmployee = service.saveEmployee(employee);

        // Then - Verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }
}
