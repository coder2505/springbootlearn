package com.example.demo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.StudentModel;

@Repository
public interface StudentInterface extends MongoRepository<StudentModel, Integer> {
    
    // GET METHODS
    StudentModel findByName(String name);  
    
}
