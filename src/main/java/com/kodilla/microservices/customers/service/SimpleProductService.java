package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;
import com.kodilla.microservices.customers.service.interfaces.CustomerAccountsProvider;
import com.kodilla.microservices.customers.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleProductService implements ProductService {

    private final CustomerAccountsProvider accountsProvider;

    @Override
    public List<AccountSnapshot> findCustomerProducts(Long customerId) {
        return accountsProvider.getCustomerAccounts(customerId);
    }
}
