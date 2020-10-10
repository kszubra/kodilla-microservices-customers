package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.request.CustomerCreateRequest;
import com.kodilla.microservices.customers.api.response.CustomerResponse;
import com.kodilla.microservices.customers.api.snapshot.CustomerSnapshot;
import com.kodilla.microservices.customers.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer mapToEntity(CustomerCreateRequest request) {
        return Customer.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .isActive(true)
                .build();
    }

    public CustomerResponse mapToResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }

    public CustomerSnapshot mapToSnapshot(Customer customer) {
        return CustomerSnapshot.builder()
                .id(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .createdAt(customer.getCreatedAt())
                .isActive(customer.getIsActive())
                .build();
    }
}
