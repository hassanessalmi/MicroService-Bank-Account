package com.example.microservice.mappers;

import com.example.microservice.DTO.BankAccountRespenseDTO;
import com.example.microservice.entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountRespenseDTO fromBankAccount(BankAccount bankAccount){

        BankAccountRespenseDTO bankAccountRespenseDTO =new BankAccountRespenseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountRespenseDTO);
        return bankAccountRespenseDTO;
    }
}
