package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("Student")
public class StudentModel {
    
    @Id
    String id;

    @NotNull(message = "name field cannot be null")
    String name;

    @NotNull(message = "roll_number cannot be null")
    @Min(value=1)
    int roll_number;

    @NotNull(message = "address cannot be null")
    String address;

    @PositiveOrZero(message="marks has to be greater than or equal to 0")
    @NotNull(message = "marks cannot be null")
    int marks;

}
