package com.kodilla.microservices.customers.domain.repository;

import com.kodilla.microservices.customers.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);
}
