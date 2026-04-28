package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.StudentModel;
import com.example.demo.repository.StudentInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutStudentService {

    StudentInterface studentInterface;

    public String PutStudent(String id, StudentModel student) {

        if (studentInterface.existsById(id)) {
            student.setId(id);
            studentInterface.save(student);
        } else {
            throw new RuntimeException("Student with ID " + id + " not found.");
        }   

    return "Success";

    }
}
