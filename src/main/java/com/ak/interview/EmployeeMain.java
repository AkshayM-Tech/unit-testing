package com.ak.interview;

import java.util.Arrays;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {

        System.err.println(Integer.MAX_VALUE);
        System.err.println(Integer.MIN_VALUE);

        System.err.println(7/2);

        System.exit(0);
        List<Employee> employees = List.of(
                Employee.builder()
                        .id(1)
                        .name("A")
                        .age(10)
                        .salary(10000)
                        .build(),
                Employee.builder()
                        .id(2)
                        .name("B")
                        .age(20)
                        .salary(20000)
                        .build(),
                Employee.builder()
                        .id(3)
                        .name("C")
                        .age(30)
                        .salary(30000)
                        .build(),
                Employee.builder()
                        .id(4)
                        .name("D")
                        .age(40)
                        .salary(40000)
                        .build(),
                Employee.builder()
                        .id(5)
                        .name("E")
                        .age(50)
                        .salary(50000)
                        .build()
        );

        double sal = 10000 + 20000 + 30000 + 40000 + 50000;
        System.err.println("Sal : "+sal);
        System.err.println("Sal : "+sal/ employees.size());
        // Find emp age >= 30
        // Avg salary

        employees.stream()
                .filter(employee -> employee.getAge() >= 30)
                .forEach(System.out::println);

        double avgSalary = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum) / employees.size();
        System.err.println("average Salary : "+avgSalary);

    }
}
