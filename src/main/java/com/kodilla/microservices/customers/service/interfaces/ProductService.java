package com.kodilla.microservices.customers.service.interfaces;

import com.kodilla.microservices.customers.api.response.CustomerProductsResponse;
import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;

import java.util.List;

public interface ProductService {

    List<AccountSnapshot> findCustomerProducts(Long customerId);
}
