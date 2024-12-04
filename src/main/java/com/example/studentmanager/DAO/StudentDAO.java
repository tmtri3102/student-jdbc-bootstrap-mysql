package com.example.studentmanager.DAO;

import com.example.studentmanager.model.Student;
import com.example.studentmanager.service.StudentService;
import com.example.studentmanager.model.Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentService {

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }


    @Override
    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();
        try (
                Connection conn = getConnection();
                CallableStatement call = conn.prepareCall("{call list_students()}")
        ){
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int class_id = rs.getInt("class_id");
                Student student = new Student(id, name, class_id);
                students.add(student);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return students;
    }

    @Override
    public void createStudent(String name, int class_id) {
        try (
                Connection conn = getConnection();
                CallableStatement call = conn.prepareCall("{call add_student(?,?,?)}")
        ) {
            call.setString(1, name);
            call.setInt(2, class_id);
            int rowAffected = call.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Insert failed!");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Student searchById(int id) {
        Student student = null;
        try (
                Connection conn = getConnection();
                CallableStatement call = conn.prepareCall("{call find_student(?)}")
        ) {
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int class_id = rs.getInt("class_id");
                student = new Student(id, name, class_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    @Override
    public void updateStudent(int id, Student student) {
        try (
                Connection conn = getConnection();
                CallableStatement call = conn.prepareCall("{call update_student(?,?,?,?)}")
        ) {
            call.setInt(1, id);
            call.setString(2, student.getName());
            call.setInt(3, student.getClassId());
            int rowAffected = call.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Update failed!");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try (
                Connection conn = getConnection();
                CallableStatement call = conn.prepareCall("{call delete_student(?)}")
        ) {
            call.setInt(1, id);
            int rowAffected = call.executeUpdate();
            if (rowAffected == 0) {
                throw new SQLException("Student with id " + id + " not found");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Classes> getAllClasses() {
        List<Classes> classes_list = new ArrayList<>();
        try (
                Connection conn = getConnection();
                CallableStatement cstmt = conn.prepareCall("{call list_classes()}")
        ) {
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Classes newClass = new Classes(id, name);
                classes_list.add(newClass);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return classes_list;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
