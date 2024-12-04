package com.example.studentmanager.service;

import com.example.studentmanager.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student(1, "Macbook", "Nice laptop", 52.25));
        students.put(2, new Student(2, "Yoga laptop", "Nice laptop", 34.50));
        students.put(3, new Student(3, "LG Laptop", "Nice laptop", 45.65));
        students.put(4, new Student(4, "Asus Vivobook", "Nice laptop", 56.75));
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void createStudent(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student searchById(int id) {
        return students.get(id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void deleteStudent(int id) {
        students.remove(id);
    }
}
