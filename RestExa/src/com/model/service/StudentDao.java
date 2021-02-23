package com.model.service;
import java.sql.SQLException;
import java.util.List;

import com.model.example.Student;

public interface StudentDao {
public  List<Student>listAllStudents() ;
public Student getStudent(int id);
public Student addStudent(Student student);
public void deleteStudent(int id);
public Student updateStudent(Student student);
public void getStudentMarks(int id);
}
