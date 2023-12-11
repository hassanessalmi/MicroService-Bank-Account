package com.example.microservice.DTO;

import com.example.microservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountRespenseDTO {
    private String id;
    private Date createdAT;
    private Double balance;
    private String currency;

    private AccountType type;
}
