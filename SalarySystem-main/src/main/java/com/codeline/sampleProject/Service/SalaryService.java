package com.codeline.sampleProject.Service;

import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.Repository.SalaryRepository;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {
    @Autowired
    SalaryRepository salaryRepository;

    public void saveSalary(Salary salary) {
        salaryRepository.save(salary);
    }


    public List<Salary> getSalary() {
        return salaryRepository.findAll();
    }

    public GetSalaryResponse getSalaryById(Long salaryId) {
        Optional<Salary> optionalSalary =  salaryRepository.findById(salaryId);
        if(!optionalSalary.isEmpty())
        {
            Salary salary =  optionalSalary.get();
            GetSalaryResponse salaryResponse = new GetSalaryResponse(salary.getAmount(), salary.getCurrency(), salary.getOverTimeAmount());
            return salaryResponse;
        }

        return null;

    }
}
