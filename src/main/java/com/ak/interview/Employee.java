package com.ak.interview;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    private int id;
    private double age;
    private String name;
    private double salary;
}
