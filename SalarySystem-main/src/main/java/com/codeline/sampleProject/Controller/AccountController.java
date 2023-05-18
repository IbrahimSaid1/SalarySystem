package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.Service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("account/create")
    public void saveAccount (@RequestBody GetAccountRequestObject accountRequestObject) {
        createAccount(accountRequestObject);}

    @RequestMapping("account/get")
    public List<Account> getAccount () {
        return accountService.getAccount();
    }

    @RequestMapping("account/get/{accountId}")
    public GetAccountResponse createAccount (@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @GetMapping("account/quer")
    @ResponseBody
    public String getaccountQueryString(@RequestParam String a,@RequestParam String b,@RequestParam String c) throws JsonProcessingException {
        Account account = new Account();
        account.setBankName(a);
        account.setAccountNumber(b);
        account.setBankBranch(c);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(accountService.getAccountAsString(account));
        System.out.print(s);
        return s;
    }
    public void createAccount(GetAccountRequestObject accountRequestObject) {
        Account account= new Account();
        account.setBankName(accountRequestObject.getBankName());
        account.setAccountNumber(accountRequestObject.getAccountNumber());
        account.setBankBranch(accountRequestObject.getBankBranch());
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
