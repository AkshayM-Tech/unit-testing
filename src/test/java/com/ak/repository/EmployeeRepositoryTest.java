package com.ak.repository;

import com.ak.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    @DisplayName("Junit test for save employee operation")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){
        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                                    .firstName("Akshay")
                                    .lastName("Mache")
                                    .email("akshay.k.mache@gmail.com")
                                    .build();

        // When - Action or Behaviour that we are going to test
        Employee savedEmployee = repository.save(employee);

        System.err.println("Saved Employee : "+savedEmployee);
        // Then - Verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);
        Assertions.assertThat(savedEmployee.getFirstName()).isNotNull();
    }

    // Unit test for get all employees
    @Test
    @DisplayName("Unit test for get all employees")
    public void givenEmployees_whenFindAll_thenReturnEmployeeList(){

        // Given - Pre-Condition or Setup
        Employee employee01 = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();

        Employee employee02 = Employee.builder()
                .firstName("Priya")
                .lastName("Mache")
                .email("priya.mache@gmail.com")
                .build();

        Employee employee03 = Employee.builder()
                .firstName("Avinash")
                .lastName("Mache")
                .email("avinash.mache@gmail.com")
                .build();

        repository.save(employee01);
        repository.save(employee02);
        repository.save(employee03);

        // When - Action or behaviour we are going to test
        List<Employee> employees = repository.findAll();

        // Then - Verify the output
        Assertions.assertThat(employees).isNotEmpty();
        Assertions.assertThat(employees).hasSize(3);
    }

    // Unit test for get employee by id.
    @Test
    @DisplayName("Unit test for get employee by id")
    public void givenEmployeeId_whenFindById_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();

        repository.save(employee);

        // When - Action or behaviour that we are going to test
        Employee obj = repository.findById(employee.getId()).get();

        // Then - Verify the output
        Assertions.assertThat(obj).isNotNull();
    }

    // Unit test for get employee by email
    @Test
    @DisplayName("Unit test for get employee by email")
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmaployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();

        repository.save(employee);

        // When - Action or behaviour that we are going to test
        Employee object = repository.findByEmail(employee.getEmail());

        // Then - Verify the output
        Assertions.assertThat(object).isNotNull();
    }

    // Unit test for update employee
    @Test
    @DisplayName("Unit test for update employee")
    public void givenEmployee_whenUpdate_thenReturnUpdatedEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();

        repository.save(employee);

        // When - Action or behaviour that we are going to test
        Employee savedEmployee = repository.findById(employee.getId()).get();
        savedEmployee.setFirstName("Avinash");
        savedEmployee.setEmail("avinash.k.mache@gmail.com");
        Employee updatedEmployee = repository.save(savedEmployee);

        // Then - Verify the output
        Assertions.assertThat(updatedEmployee).isNotNull();
        Assertions.assertThat(updatedEmployee.getFirstName()).isEqualTo("Avinash");
        Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo("avinash.k.mache@gmail.com");
    }

    // Unit test for delete employee
    @Test
    @DisplayName("Unit test for delete employee")
    public void givenEmployee_whenDeleteEmployee_thenRemoveEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();

        repository.save(employee);

        // When - Action or behaviour that we are going to test
        repository.delete(employee);
        Employee deletedEmployee = repository.findById(employee.getId()).orElse(null);

        // Then - Verify the output
        Assertions.assertThat(deletedEmployee).isNull();
    }

    // Unit test for custom JPQL query using index params
    @Test
    @DisplayName("Unit test for custom JPQL query using index params")
    public void givenEmployeeFirstAndLastName_whenFindByJPQLUsingIndexParams_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
        repository.save(employee);

        String firstName = "Akshay";
        String lastName = "Mache";

        // When - Action or behaviour that we are going to test
        Employee result = repository.findByJPQLUsingIndexParams(firstName, lastName);

        // Then - Verify the output
        Assertions.assertThat(result).isNotNull();
    }

    // Unit test for custom JPQL query using named params
    @Test
    @DisplayName("Unit test for custom JPQL query using named params")
    public void givenEmployeeFirstAndLastName_whenFindByJPQLUsingNamedParams_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
        repository.save(employee);

        String firstName = "Akshay";
        String lastName = "Mache";

        // When - Action or behaviour that we are going to test
        Employee result = repository.findByJPQLUsingNamedParams(firstName, lastName);

        // Then - Verify the output
        Assertions.assertThat(result).isNotNull();
    }

    // Unit test for custom native SQL query using index params
    @Test
    @DisplayName("Unit test for custom native SQL query using index params")
    public void givenEmployeeFirstAndLastName_whenFindByNativeSQLUsingIndexParams_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
        repository.save(employee);

        String firstName = "Akshay";
        String lastName = "Mache";

        // When - Action or behaviour that we are going to test
        Employee result = repository.findByNativeSQLUsingIndexParams(firstName, lastName);

        // Then - Verify the output
        Assertions.assertThat(result).isNotNull();
    }

    // Unit test for custom native SQL query using named params
    @Test
    @DisplayName("Unit test for custom native SQL query using named params")
    public void givenEmployeeFirstAndLastName_whenFindByNativeSQLUsingNamedParams_thenReturnEmployee(){

        // Given - Pre-Condition or Setup
        Employee employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
        repository.save(employee);

        String firstName = "Akshay";
        String lastName = "Mache";

        // When - Action or behaviour that we are going to test
        Employee result = repository.findByNativeSQLUsingNamedParams(firstName, lastName);

        // Then - Verify the output
        Assertions.assertThat(result).isNotNull();
    }
}
