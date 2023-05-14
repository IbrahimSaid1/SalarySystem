package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController

public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("account/create")
    public void saveAccount () {
        createAccount();}

    @RequestMapping("account/get")
    public List<Account> getAccount () {
        return accountService.getAccount();
    }


    public void createAccount() {
        Account account= new Account();
        account.setBankName("Muscat");
        account.setAccountNumber("45454");
        account.setBankBranch("Muscat");
        account.setSwiftCode("MUS1100");
        account.setAccountHolderName("Ibrahim");
        account.setAccountType("Normal");
        account.setBranchCode(112);
        account.setCreatedDate(new Date());
        account.setUpdatedDate(new Date());
        account.setIsActive(true);
        accountService.saveAccount(account);
    }
}
