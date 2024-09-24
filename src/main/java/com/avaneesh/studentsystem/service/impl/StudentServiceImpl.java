package com.avaneesh.studentsystem.service.impl;

import com.avaneesh.studentsystem.model.Student;
import com.avaneesh.studentsystem.repository.StudentRepository;
import com.avaneesh.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //To find all the list of all the students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //To create data for a single student
    @Override
    public String createStudentData(Student student) {
        if(student.getName().isEmpty() || student.getGender().isEmpty()) //name and gender cannot be null
            return "Student Name or Gender Cannot be Empty!!!";
        studentRepository.save(student); //save the student data
        return "Student Info. saved Successfully!!\nStudent ID = "+student.getId() + "\nStudent Name = "+student.getName()+"\nStudent Gender = "+student.getGender();
    }

    //To get the data of a single student
    @Override
    public String getStudentData(Long id) {
        if(studentRepository.findById(id).isPresent())
            return "Student ID = "+id + "\nStudent Name = "+studentRepository.findById(id).get().getName()+"\nStudent Gender = "+studentRepository.findById(id).get().getGender();
        return "NO Student Found with the given ID no. = "+id + " !!!!";
    }

    //To update the data of a single student
    @Override
    public String updateStudentData(Long id, Student student) {
        if(studentRepository.findById(id).isPresent()) { //if student is present
            if(student.getGender().isEmpty() || student.getName().isEmpty()){ //name and gender cannot be null
                return "Student Name or Student Gender Cannot be Empty!!!";
            }
            Student studentData = studentRepository.findById(id).get();
            studentData.setName(student.getName()); //set new name
            studentData.setGender(student.getGender()); //set new gender
            studentRepository.save(studentData); //save the student info. with same id
            return "Updated Info. => \nStudent ID = " + id + "\nStudent Name = " + studentRepository.findById(id).get().getName() + "\nStudent Gender = " + studentRepository.findById(id).get().getGender();
        }
        return "NO Student Found with the given ID no. = "+id + " !!!!";
    }

    //To delete the data of a single student
    @Override
    public String deleteStudentData(Long id) {
        if(studentRepository.findById(id).isPresent()) { //if student is present
            studentRepository.delete(studentRepository.findById(id).get()); //delete the info.
            return "Student Info. Deleted Successfully!!";
        }
        return "NO Student Found with the given ID no. = "+id + " !!!!";
    }
}
