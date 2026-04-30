package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ApiResponse;
import com.example.demo.models.StudentModel;
import com.example.demo.services.DeleteStudentService;
import com.example.demo.services.GetStudentService;
import com.example.demo.services.PutStudentService;
import com.example.demo.services.SaveStudentService;

import jakarta.validation.Valid;

@RestController
public class basicCallsController {

    private final SaveStudentService saveStudentService;
    private final GetStudentService getStudentService;
    private final DeleteStudentService deleteStudentService;
    private final PutStudentService putStudentService;

    public basicCallsController(SaveStudentService saveStudentService, GetStudentService getStudentService,
            DeleteStudentService deleteStudentService, com.example.demo.services.PutStudentService putStudentService) {
        this.saveStudentService = saveStudentService;
        this.getStudentService = getStudentService;
        this.deleteStudentService = deleteStudentService;
        this.putStudentService = putStudentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentModel>>> getMethodName() {
        List<StudentModel> resp = getStudentService.GetAllStudents();
        ApiResponse<List<StudentModel>> obj = new ApiResponse<>(true, "Fetched Succcesfully",200, resp);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentModel>> postMethodName(@Valid @RequestBody StudentModel model) {
        StudentModel s = saveStudentService.createAndSaveStudent(model);
        ApiResponse<StudentModel> obj = new ApiResponse<>(true, "updated successfully",200, s);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ApiResponse<StudentModel>> putMethodName(@PathVariable String id, @RequestBody StudentModel student) {

        StudentModel updatedStudent = putStudentService.PutStudent(id, student);

        ApiResponse<StudentModel> response = new ApiResponse<>(
                true,
                "Student updated successfully",
                200,
                updatedStudent
        );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMethodName(@PathVariable String id) {

        deleteStudentService.DeleteStudentById(id);

        ApiResponse<Void> response = new ApiResponse<>(
                true,
                "Student deleted successfully",
                200,
                null);

        return ResponseEntity.ok(response);
    }

}
