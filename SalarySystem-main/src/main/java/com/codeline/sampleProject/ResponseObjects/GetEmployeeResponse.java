package com.codeline.sampleProject.ResponseObjects;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {

    String name;
    String Gender;

    String department;
    Double salary;



}