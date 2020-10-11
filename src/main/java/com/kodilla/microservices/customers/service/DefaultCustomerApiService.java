package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.request.CustomerCreateRequest;
import com.kodilla.microservices.customers.api.response.CustomerProductsResponse;
import com.kodilla.microservices.customers.api.response.CustomerResponse;
import com.kodilla.microservices.customers.api.snapshot.CustomerSnapshot;
import com.kodilla.microservices.customers.service.interfaces.CustomerApiService;
import com.kodilla.microservices.customers.service.interfaces.CustomerService;
import com.kodilla.microservices.customers.service.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DefaultCustomerApiService implements CustomerApiService {

    private final ProductService productService;
    private final CustomerService customerService;

    @Override
    @Transactional
    public Long createCustomer(CustomerCreateRequest request) {
        return customerService.createCustomer(request);
    }

    @Override
    public CustomerResponse getCustomerResponse(Long customerId) {
        return customerService.getCustomerResponse(customerId);
    }

    @Override
    public CustomerSnapshot getCustomerSnapshot(Long customerId) {
        return customerService.getCustomerSnapshot(customerId);
    }

    @Override
    public CustomerProductsResponse findCustomerProducts(Long customerId) {
        CustomerSnapshot customer = getCustomerSnapshot(customerId);
        return CustomerProductsResponse.builder()
                .customerId(customer.getId())
                .fullName(String.format("%s %s", customer.getFirstName(), customer.getLastName()))
                .accounts(productService.findCustomerProducts(customer.getId()))
                .build();
    }
}
