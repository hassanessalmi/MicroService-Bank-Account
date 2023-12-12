package com.example.microservice;

import com.example.microservice.entities.BankAccount;
import com.example.microservice.entities.Customer;
import com.example.microservice.enums.AccountType;
import com.example.microservice.repositories.customerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.microservice.repositories.BankAccountRepository;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner Start(BankAccountRepository bankAccountRepository, customerRepository customerRepository){
        return args -> {
            Stream.of(
                    "mohamed","hassan","younes"
            ).forEach(
                    c->{
                        Customer customer=Customer.builder()
                                .name(c)
                                .build();
                        customerRepository.save(customer);
                    }
            );
            customerRepository.findAll().forEach(customer -> {

                for (int i=0;i<10;i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(10000 + Math.random() * 90000)
                            .createdAT(new Date())
                            .currency("MAD")
                            .customer(customer)
                            .build();
                    bankAccountRepository.save(bankAccount);

                }

            });


        };
    }

}
