package com.ak.service;

import com.ak.exception.ResourceNotFoundException;
import com.ak.model.Employee;
import com.ak.repository.EmployeeRepository;
import com.ak.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest01 {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeServiceImpl service;

    private Employee employee;

    @BeforeEach
    public void setUp(){
        employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
    }

    // Unit test for save employee operation using @Mock & @ InjectMock annotation.
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
        Mockito.verify(repository, Mockito.times(1)).findByEmail(employee.getEmail());
        Mockito.verify(repository, Mockito.times(1)).save(employee);
    }

    // Unit test for save non-existing employee (throw exception scenario)
    @Test
    @DisplayName("Unit test for save non-existing employee (throw exception)")
    public void givenExistingEmail_whenSaveEmployee_thenThrowException(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findByEmail(employee.getEmail())).thenReturn(employee);
        //Mockito.when(repository.save(employee)).thenReturn(employee);

        // When - Action or behaviour that we are going to test
        ResourceNotFoundException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        ResourceNotFoundException.class,
                        () -> service.saveEmployee(employee));

        // Then - Verify the output
        org.junit.jupiter.api.Assertions.assertEquals("Employee already exists with given email : "+employee.getEmail(), exception.getMessage());
        Mockito.verify(repository, Mockito.never()).save(any(Employee.class));
        Mockito.verify(repository, Mockito.times(1)).findByEmail(employee.getEmail());
    }

    // Unit test for get all employees
    @Test
    @DisplayName("Unit test for get all employees")
    public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeeList(){

        // Given - Pre-Condition or Setup
        List<Employee> employees = List.of(
                Employee.builder()
                        .firstName("Akshay")
                        .lastName("Mache")
                        .email("akshay.k.mache@gmail.com")
                        .build(),
                Employee.builder()
                        .firstName("Avinash")
                        .lastName("Mache")
                        .email("avinash.k.mache@gmail.com")
                        .build(),
                Employee.builder()
                        .firstName("Arnav")
                        .lastName("Mache")
                        .email("arnav.n.mache@gmail.com")
                        .build(),
                Employee.builder()
                        .firstName("Priya")
                        .lastName("Mache")
                        .email("priya.a.mache@gmail.com")
                        .build(),
                Employee.builder()
                        .firstName("Krushna")
                        .lastName("Kale")
                        .email("krushna.s.kale@gmail.com")
                        .build()
        );

        //Mockito.when(repository.findAll()).thenReturn(employees);
        BDDMockito.given(repository.findAll()).willReturn(employees);

        // When - Action or behaviour that we are going to test
        List<Employee> result = service.getAllEmployees();

        // Then - Verify the output
        Assertions.assertThat(result).hasSize(5);
        Assertions.assertThat(result).isNotEmpty();
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    // Unit test for get all employees negative scenario
    @Test
    @DisplayName("Unit test for get all employee negative scenario")
    public void givenEmptyEmployeeList_whenGetAllEmployee_thenReturnEmptyEmployeeList(){

        // Given - Pre-Condition or Setup
        BDDMockito.given(repository.findAll()).willReturn(List.of());

        // When - Action or behaviour that we are going to test
        List<Employee> employees = service.getAllEmployees();

        // Then - Verify the output
        Assertions.assertThat(employees).isEmpty();
        Assertions.assertThat(employees).hasSize(0);
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    // Unit test for get employee by ID.
    @Test
    @DisplayName("Unit test for get employee by Id")
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        BDDMockito.given(repository.findById(employee.getId())).willReturn(Optional.ofNullable(employee));

        // When - Action or behaviour that we are going to test
        Employee result = service.getEmployeeById(employee.getId());

        // Then - Verify the output
        Assertions.assertThat(result).isNotNull();
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
    }

    // Unit test for get employee by id (non-existing) throw exception scenario
    @Test
    @DisplayName("Unit test for get employee by id (non-existing) throw scenario")
    public void givenNonExistingEmployeeId_whenGetEmployeeById_thenThrowException(){

        // Given - Pre-Condition or Setup
        BDDMockito.given(repository.findById(employee.getId())).willReturn(Optional.empty());

        // When - Action or behaviour that we are going to test
        ResourceNotFoundException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        ResourceNotFoundException.class,
                        () -> service.getEmployeeById(employee.getId()));

        // Then - Verify the output
        org.junit.jupiter.api.Assertions.assertEquals("Employee does not exist for given Id : "+employee.getId(), exception.getMessage());
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
    }

    // Unit test for update employee operation
    @Test
    @DisplayName("Unit test for update employee operation")
    public void givenEmployee_whenUpdateEmployee_thenReturnUpdatedEmployee(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findById(employee.getId())).thenReturn(Optional.of(employee));
        employee.setFirstName("Priya");
        employee.setEmail("priya.a.mache@gmail.com");
        Mockito.when(repository.save(employee)).thenReturn(employee);

        // When - Action or behaviour that we are going to test
        Employee updatedEmployee = service.updateEmployee(employee);

        // Then - Verify the output
        Assertions.assertThat(updatedEmployee).isNotNull();
        Assertions.assertThat(updatedEmployee.getFirstName()).isEqualTo("Priya");
        Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo("priya.a.mache@gmail.com");
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
        Mockito.verify(repository, Mockito.times(1)).save(employee);

    }

    // Unit test for update non-existing employee throw exception
    @Test
    @DisplayName("Unit test for update non-existing employee throw exception")
    public void givenNonExistingEmployee_whenUpdateEmployee_thenThrowException(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findById(employee.getId())).thenReturn(Optional.empty());
        //Mockito.when(repository.save(employee)).thenReturn(null); -- Unwanted stubbing

        // When - Action or behaviour that we are going to test
        ResourceNotFoundException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        ResourceNotFoundException.class,
                        () -> service.updateEmployee(employee));

        // Then - Verify the output
        Mockito.verify(repository, Mockito.never()).save(any());
        org.junit.jupiter.api.Assertions.assertEquals("Employee does not exist from given Id : "+employee.getId(), exception.getMessage());
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
    }

    // Unit test for delete employee operation
    @Test
    @DisplayName("Unit test for delete employee operation")
    public void givenExistingEmployee_whenDeleteEmployee_thenDeleteEmployee(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findById(employee.getId())).thenReturn(Optional.of(employee));

        // Below 2 method calls are same (1st is from Mockito & 2nd is from BDDMockito)
        //Mockito.doNothing().when(repository).deleteById(employee.getId());
        BDDMockito.willDoNothing().given(repository).deleteById(employee.getId());

        // When - Action or behaviour that we are going to test
        service.deleteEmployee(employee.getId());

        // Then - Verify the output
        Mockito.verify(repository, Mockito.times(1)).deleteById(employee.getId());
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
    }

    // Unit test for delete non-existing employee (throw exception scenario)
    @Test
    @DisplayName("Unit test for non-existing employee (throw exception)")
    public void givenNonExistingEmployeeId_whenDeleteEmployee_thenThrowException(){

        // Given - Pre-Condition or Setup
        Mockito.when(repository.findById(employee.getId())).thenReturn(Optional.empty());
        //Mockito.doNothing().when(repository).deleteById(employee.getId()); -- Unwanted stubbing

        // When - Action or behaviour that we are going to test
        ResourceNotFoundException exception =
                org.junit.jupiter.api.Assertions.assertThrows(
                        ResourceNotFoundException.class,
                        () -> service.deleteEmployee(employee.getId()));

        // Then - Verify the output
        Mockito.verify(repository, Mockito.never()).deleteById(any());
        org.junit.jupiter.api.Assertions.assertEquals("Employee does not exist from given Id : "+employee.getId(), exception.getMessage());
        Mockito.verify(repository, Mockito.times(1)).findById(employee.getId());
    }
}
