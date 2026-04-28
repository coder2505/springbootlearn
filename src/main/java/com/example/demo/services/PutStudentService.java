package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.StudentModel;
import com.example.demo.repository.StudentInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutStudentService {

    StudentInterface studentInterface;

    public StudentModel PutStudent(String id, StudentModel student) {

        StudentModel s;

        if (studentInterface.existsById(id)) {
            student.setId(id);
            s = studentInterface.save(student);
        } else {
            throw new ResourceNotFoundException("The id does not exist");
        }   

        return s;

    }
}
