package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
