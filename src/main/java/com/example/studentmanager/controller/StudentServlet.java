package com.example.studentmanager.controller;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.StudentService;
import com.example.studentmanager.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
            // -> back to localhost?
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "update":
                showUpdatePage(request, response);
                break;
            case "delete":
                showDeletePage(request, response);
                break;
            case "view":
                viewDetail(request, response);
                break;
            default:
                listStudents(request, response);
                break;
        }
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.searchById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/update.jsp");
        }
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeletePage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.searchById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void viewDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.searchById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            request.setAttribute("student", student);
            dispatcher = request.getRequestDispatcher("student/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void listStudents(HttpServletRequest request, HttpServletResponse response) {
        List<Student> students = this.studentService.listStudents();
        request.setAttribute("students", students);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


//====================================================================================================================================================================================================================================================================================================================================================================

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                break;
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 100);
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Student student = new Student(id, name, description, price);
        this.studentService.createStudent(student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/create.jsp");
        request.setAttribute("message",  "New student was created");
        try{
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 100);
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));

        Student student = new Student(id, name, description, price);
        RequestDispatcher dispatcher;

        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            student.setName(name);
            student.setDescription(description);
            student.setPrice(price);
            this.studentService.updateStudent(id, student);
            request.setAttribute("student", student);
            request.setAttribute("message", "Update student successfully");
            dispatcher = request.getRequestDispatcher("student/update.jsp");
        }
        try{
            dispatcher.forward(request,response);
        }
        catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = this.studentService.searchById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            this.studentService.deleteStudent(id);
            try {
                response.sendRedirect("/students");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
