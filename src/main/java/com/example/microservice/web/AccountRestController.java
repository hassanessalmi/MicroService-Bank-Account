package com.example.microservice.web;

import com.example.microservice.DTO.BankAccountRequestDTO;
import com.example.microservice.DTO.BankAccountRespenseDTO;
import com.example.microservice.entities.BankAccount;
import com.example.microservice.mappers.AccountMapper;
import com.example.microservice.repositories.BankAccountRepository;
import com.example.microservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AccountRestController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccount(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("accout %s not found ",id)));
    }
    @PostMapping ("/bankAccounts")
    public BankAccountRespenseDTO save(@RequestBody BankAccountRequestDTO bankAccount){

        return accountService.addAccount(bankAccount);

    }
    @PutMapping ("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();

        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getCreatedAT()!=null)account.setCreatedAT(new Date());
        if(bankAccount.getType()!=null) account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount);

    }
    @DeleteMapping("/bankAccounts/{id}")
    public void delete (@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }

}
