package com.example.microservice.repositories;

import com.example.microservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customer,Long> {
}
