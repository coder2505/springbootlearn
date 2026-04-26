package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StudentModel;
import com.example.demo.services.SaveStudentService;


@RestController
public class basicCallsController {

    private final SaveStudentService saveStudentService;


    public basicCallsController(SaveStudentService saveStudentService) {
        this.saveStudentService = saveStudentService;
    }

    @GetMapping
    public String getMethodName() {
        return "get";
    }

    @PostMapping
    public StudentModel postMethodName(@RequestBody StudentModel model) {        
        return saveStudentService.createAndSaveStudent(model);
    }
    
    @PutMapping
    public String putMethodName() {  
        return "put";
    }


    @DeleteMapping
    public String deleteMethodName(){
        return "delete";
    }
}
