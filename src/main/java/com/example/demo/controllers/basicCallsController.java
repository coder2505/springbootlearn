package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.StudentModel;
import com.example.demo.services.DeleteStudentService;
import com.example.demo.services.GetStudentService;
import com.example.demo.services.PutStudentService;
import com.example.demo.services.SaveStudentService;


@RestController
public class basicCallsController {

    private final SaveStudentService saveStudentService;
    private final GetStudentService getStudentService;
    private final DeleteStudentService deleteStudentService;
    private final PutStudentService putStudentService;

    public basicCallsController(SaveStudentService saveStudentService, GetStudentService getStudentService, DeleteStudentService deleteStudentService, com.example.demo.services.PutStudentService putStudentService) {
        this.saveStudentService = saveStudentService;
        this.getStudentService = getStudentService;
        this.deleteStudentService = deleteStudentService;
        this.putStudentService = putStudentService;
    }

    @GetMapping
    public List<StudentModel> getMethodName() {
        return getStudentService.GetAllStudents();
    }

    @PostMapping
    public StudentModel postMethodName(@RequestBody StudentModel model) {        
        return saveStudentService.createAndSaveStudent(model);
    }
    
    @PutMapping("/put/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody StudentModel student) {  
        return putStudentService.PutStudent(id, student);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteMethodName(@PathVariable String id){
        return deleteStudentService.DeleteStudentById(id);
    }
}
