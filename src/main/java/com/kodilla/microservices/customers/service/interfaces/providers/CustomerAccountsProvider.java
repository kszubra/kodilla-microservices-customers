package com.kodilla.microservices.customers.service.interfaces.providers;

import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;

import java.util.List;

public interface CustomerAccountsProvider {

    List<AccountSnapshot> getCustomerAccounts(Long customerId);

}
