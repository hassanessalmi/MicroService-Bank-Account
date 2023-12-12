package com.example.microservice.service;

import com.example.microservice.DTO.BankAccountRequestDTO;
import com.example.microservice.DTO.BankAccountRespenseDTO;

public interface AccountService {

    public BankAccountRespenseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountRespenseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
