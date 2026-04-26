package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.models.StudentModel;
import com.example.demo.repository.StudentInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaveStudentService {

    StudentInterface studentInterface;

    public StudentModel createAndSaveStudent(StudentModel model) {

        return studentInterface.save(model);

    }

}
