package com.example.studentmanager.controller;

import com.example.studentmanager.DAO.StudentDAO;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.model.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping
    public ModelAndView listStudents() {
        System.out.println( "listStudents()");
        ModelAndView modelAndView = new ModelAndView("list");
        List<Student> students = studentDAO.listStudents();
        modelAndView.addObject("students", students);
        List<Classes> classes = studentDAO.listClasses();
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView viewDetail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        Student student = studentDAO.searchById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping
    public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int class_id) {
        Student student = new Student(id, name, class_id);
        studentDAO.updateStudent(id, student);
        return "redirect:/students";
    }
}
