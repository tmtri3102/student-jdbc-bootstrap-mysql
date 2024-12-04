package com.example.studentmanager.service;

import com.example.studentmanager.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listStudents();
//    void createStudent(Student student);

    void createStudent(String name, int class_id);

    Student searchById(int id);
    void updateStudent(int id, Student student);
    void deleteStudent(int id);
}
