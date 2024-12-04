package com.example.studentmanager.controller;

import com.example.studentmanager.DAO.StudentDAO;
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
//    private final StudentService studentService = new StudentServiceImpl();
    private final StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
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
//        Student student = this.studentService.searchById(id);
        Student student = studentDAO.searchById(id);
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
//        Student student = this.studentService.searchById(id);
        Student student = studentDAO.searchById(id);
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
//        Student student = this.studentService.searchById(id);
        Student student = studentDAO.searchById(id);
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
//        List<Student> students = this.studentService.listStudents();
        List<Student> students = studentDAO.listStudents();
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
            case "search":
                searchStudent(request, response);
                break;
            default:
                break;
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) {
//        int id = (int) (Math.random() * 100);
        String name = request.getParameter("name");
        int class_id = Integer.parseInt(request.getParameter("class_id"));

//        Student student = new Student(name, class_id);
//        this.studentService.createStudent(name, class_id);
        studentDAO.createStudent(name, class_id);
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
//        int id = (int) (Math.random() * 100);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int class_id = Integer.parseInt(request.getParameter("class_id"));


//        Student student = new Student(name, class_id);
        Student student = studentDAO.searchById(id);

        RequestDispatcher dispatcher;

        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        }
        else {
            student.setName(name);
            student.setClassId(class_id);
            studentDAO.updateStudent(id, student);

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
        Student student = studentDAO.searchById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("error.jsp");
        } else {
            studentDAO.deleteStudent(id);
            try {
                response.sendRedirect("/students");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        List<Student> students = studentDAO.listStudents();
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                request.setAttribute("student", student);
                found = true;
                break;
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("student/view.jsp");
        if (!found) {
            request.setAttribute("message", "Student not found!");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            System.out.println(e.getMessage());
        }
    }
}
