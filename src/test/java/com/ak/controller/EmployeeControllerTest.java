package com.ak.controller;

import com.ak.model.Employee;
import com.ak.service.EmployeeService;
import com.ak.service.impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService service;

    @Autowired
    private ObjectMapper mapper;

    private Employee employee;

    @BeforeEach
    public void setUp(){
        employee = Employee.builder()
                .firstName("Akshay")
                .lastName("Mache")
                .email("akshay.k.mache@gmail.com")
                .build();
    }

    // Unit test for save employee
    @Test
    @DisplayName("Unit test for save employee")
    public void givenNonExistingEmployee_whenSaveEmployee_thenReturnSavedEmployee() throws Exception {

        // Given - Pre-Condition or Setup
        Mockito.when(service.saveEmployee(any())).thenReturn(employee);

        // When - Action or behaviour that we are going to test
        ResultActions response =
                mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(employee)));

        System.err.println("employee : "+employee);
        System.err.println("employee json : "+mapper.writeValueAsString(employee));

        // Then - Verify the output
        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Akshay"))
                .andExpect(jsonPath("$.lastName").value("Mache"))
                .andExpect(jsonPath("$.email").value("akshay.k.mache@gmail.com"));

                //.andExpect(jsonPath("$.firstName", CoreMatchers.is(employee.getFirstName())))
                //.andExpect(jsonPath("$.lastName", CoreMatchers.is(employee.getLastName())))
                //.andExpect(jsonPath("$.email", CoreMatchers.is(employee.getEmail())));
    }

    // Unit test for get all employees
    @Test
    @DisplayName("Unit test for get all employees")
    public void givenEmployeeList_whenGetAllEmployees_thenReturnEmployeesList() throws Exception {

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
                        .build()
        );
        Mockito.when(service.getAllEmployees()).thenReturn(employees);
        // When - Action or behaviour that we are going to test
        ResultActions response = mockMvc.perform(get("/api/employees"))
                .andDo(print());

        // Then - Verify the output
        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3));
    }
}
