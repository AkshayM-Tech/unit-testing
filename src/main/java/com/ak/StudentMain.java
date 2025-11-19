package com.ak;

import java.util.List;

public class StudentMain {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        List<Student> list = service.getStudents();

        System.out.println(list);

        Student student = new Student(101, "A");
        service.addStudent(student);

        addStudent(service, new Student(102, "B"));
        System.out.println(list);
    }

    private static void addStudent(StudentService service, Student student){
        service.addStudent(student);
    }
}
