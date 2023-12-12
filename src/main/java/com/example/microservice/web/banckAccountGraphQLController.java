package com.example.microservice.web;

import com.example.microservice.DTO.BankAccountRequestDTO;
import com.example.microservice.DTO.BankAccountRespenseDTO;
import com.example.microservice.entities.BankAccount;
import com.example.microservice.entities.Customer;
import com.example.microservice.repositories.BankAccountRepository;
import com.example.microservice.repositories.customerRepository;
import com.example.microservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class banckAccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
@Autowired
private customerRepository customerRepository;
    @QueryMapping
    public List<BankAccount>  accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount  bankAccountById( @Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("account %s not found",id)));
    }
    @MutationMapping
    public BankAccountRespenseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountRespenseDTO updateAccount( @Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id, bankAccount);
    }
    @MutationMapping
    public boolean deleteAccount( @Argument String id){
        bankAccountRepository.deleteById(id);
        return true;
    }
    @QueryMapping
    public List<Customer>  CustomerList(){
        return customerRepository.findAll();
    }



}
/*
record BankAccountDTo(double balance,String type,String currency){

}*/
