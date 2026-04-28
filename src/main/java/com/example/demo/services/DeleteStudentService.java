package com.example.demo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.StudentModel;
import com.example.demo.repository.StudentInterface;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteStudentService {
    
    private final StudentInterface studentInterface;

    public String DeleteStudentById(String id){
        
        Optional<StudentModel> optionalStudent =  studentInterface.findById(id);

        if(optionalStudent.isPresent()){
            
            studentInterface.deleteById(id);
            return "Success";

        }

        return "Id is not present in the database";


    }

}
