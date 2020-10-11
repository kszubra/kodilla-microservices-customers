package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;
import com.kodilla.microservices.customers.connector.AccountsConnector;
import com.kodilla.microservices.customers.service.interfaces.providers.CustomerAccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleAccountsProvider implements CustomerAccountsProvider {

    private final AccountsConnector accountsConnector;

    @Override
    public List<AccountSnapshot> getCustomerAccounts(Long customerId) {
        return accountsConnector.getAccounts(customerId)
                .getAccounts();
    }
}
