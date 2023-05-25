package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Repository.EmployeeRepository;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public GetEmployeeResponse getEmployeeById(Long employeeId) {
        Optional<Employee> optionalEmployee =  employeeRepository.findById(employeeId);
        if(!optionalEmployee.isEmpty())
        {
            Employee employee =  optionalEmployee.get();
            GetEmployeeResponse employeeResponse = new GetEmployeeResponse(employee.getName(), employee.getGender(), employee.getDepartment(), employee.getSalary());
            return employeeResponse;
        }

        return null;

    }

    public GetEmployeeResponse getEmployeeAsString(Employee employee) {
        GetEmployeeResponse empolyeeResponse = new GetEmployeeResponse(employee.getName(), employee.getDepartment(), employee.getGender(), employee.getSalary());
        return empolyeeResponse;
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
