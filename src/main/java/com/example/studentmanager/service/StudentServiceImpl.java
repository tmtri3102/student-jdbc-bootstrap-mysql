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
        students.put(1, new Student(1, "Tri",  52));
        students.put(2, new Student(2, "Loc ", 34));
        students.put(3, new Student(3, "Dung ", 45));
        students.put(4, new Student(4, "Thang ",56));
    }

    @Override
    public List<Student> listStudents() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void createStudent(String name, int class_id) {

    }

//    @Override
//    public void createStudent(Student student) {
//        students.put(student.getId(), student);
//    }

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
