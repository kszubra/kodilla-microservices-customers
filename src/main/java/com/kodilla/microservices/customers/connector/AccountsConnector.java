package com.kodilla.microservices.customers.connector;

import com.kodilla.microservices.customers.api.response.CustomerAccountsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "accounts", fallback = AccountsConnectorFallback.class)
public interface AccountsConnector {

    @GetMapping("/v1/accounts")
    CustomerAccountsResponse getAccounts(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class AccountsConnectorFallback implements AccountsConnector {
    @Override
    public CustomerAccountsResponse getAccounts(Long customerId) {
        log.warn("Can not get accounts for customer with id: {}", customerId);
        return new CustomerAccountsResponse(Collections.emptyList());
    }
}
