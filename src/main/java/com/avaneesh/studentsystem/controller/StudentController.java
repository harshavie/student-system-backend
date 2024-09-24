package com.avaneesh.studentsystem.controller;

import com.avaneesh.studentsystem.model.Student;
import com.avaneesh.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student-data")
    public String createStudentData(@RequestBody Student student) {
        return studentService.createStudentData(student);
    }

    @GetMapping("/get-student-data/{id}")
    public String getStudentData(@PathVariable Long id) {
        return studentService.getStudentData(id);
    }

    @PutMapping("/update-student-data/{id}")
    public String updateStudentData(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudentData(id,student);
    }

    @DeleteMapping("/delete-student-data/{id}")
    public String deleteStudentData(@PathVariable Long id){
        return studentService.deleteStudentData(id);
    }
    @GetMapping("/get-all-students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
}
