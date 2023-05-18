package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Salary;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObject;
import com.codeline.sampleProject.RequestObjects.GetSalaryRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetSalaryResponse;
import com.codeline.sampleProject.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @RequestMapping("salary/create")
    public void saveSalary(@RequestBody GetSalaryRequestObject salaryRequestObject) {
        createSalary(salaryRequestObject);}

    @RequestMapping("salary/get")
    public List<Salary> getSalary () {
        return salaryService.getSalary();
    }

    @RequestMapping("salary/get/{salarytId}")
    public GetSalaryResponse createSalary (@PathVariable Long salarytId) {
        return salaryService.getSalaryById(salarytId);
    }


    public void createSalary(GetSalaryRequestObject salaryRequestObject){
        Salary salary= new Salary();
        salary.setAmount(salaryRequestObject.getAmount());
        salary.setCurrency(salaryRequestObject.getCurrency());
        salary.setOverTimeAmount(salaryRequestObject.getOverTimeAmount());
        salary.setDeductions(00.00);
        salary.setHealthCareContribution(70.00);
        salary.setAllowances(200.00);
        salary.setBonus(30.00);
        salary.setPerDiem(35.00);
        salary.setCreatedDate(new Date());
        salary.setUpdatedDate(new Date());
        salary.setIsActive(true);
        salaryService.saveSalary(salary);
    }



}
