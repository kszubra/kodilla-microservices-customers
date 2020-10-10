package com.kodilla.microservices.customers.service.interfaces;

import com.kodilla.microservices.customers.api.request.CustomerCreateRequest;
import com.kodilla.microservices.customers.api.response.CustomerResponse;
import com.kodilla.microservices.customers.api.snapshot.CustomerSnapshot;

public interface CustomerService {

    Long createCustomer(CustomerCreateRequest request);

    CustomerResponse getCustomerResponse(Long customerId);

    CustomerSnapshot getCustomerSnapshot(Long customerId);
}
