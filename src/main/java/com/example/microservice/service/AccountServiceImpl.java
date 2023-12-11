package com.example.microservice.service;

import com.example.microservice.DTO.BankAccountRequestDTO;
import com.example.microservice.DTO.BankAccountRespenseDTO;
import com.example.microservice.entities.BankAccount;
import com.example.microservice.mappers.AccountMapper;
import com.example.microservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
   private  AccountMapper accountMapper;
    @Override
    public BankAccountRespenseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAT(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
      BankAccount saveAccount=  bankAccountRepository.save(bankAccount);



     BankAccountRespenseDTO  bankAccountRespenseDTO=accountMapper.fromBankAccount(saveAccount);
        return bankAccountRespenseDTO;
    }
}
