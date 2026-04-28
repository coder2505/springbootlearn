package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.StudentModel;
import com.example.demo.repository.StudentInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetStudentService {

    StudentInterface studentInterface;

    public List<StudentModel> GetAllStudents() {
        
        return studentInterface.findAll();

    }

}
