package com.avaneesh.studentsystem.service;

import com.avaneesh.studentsystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    String createStudentData(Student student);
    String getStudentData(Long id);
    String updateStudentData(Long id, Student student);
    String deleteStudentData(Long id);
    List<Student> getAllStudents();
}
