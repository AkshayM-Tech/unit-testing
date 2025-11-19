package com.ak.repository;

import com.ak.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);

    // Define custom JPQL query using index params
    @Query("FROM Employee WHERE firstName = ?1 AND lastName = ?2")
    public Employee findByJPQLUsingIndexParams(String firstName, String lastName);

    // Define custom JPQL query using named params
    @Query("FROM Employee WHERE firstName =:firstName AND lastName =:lastName")
    public Employee findByJPQLUsingNamedParams(String firstName, String lastName);

    // Define custom JPQL query using index params
    @Query(value = "SELECT * FROM employees WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    public Employee findByNativeSQLUsingIndexParams(String firstName, String lastName);

    // Define custom JPQL query using named params
    @Query(value = "SELECT * FROM employees WHERE first_name =:firstName AND last_name =:lastName", nativeQuery = true)
    public Employee findByNativeSQLUsingNamedParams(String firstName, String lastName);
}
