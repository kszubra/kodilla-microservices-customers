package com.kodilla.microservices.customers;

import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;
import com.kodilla.microservices.customers.service.interfaces.providers.CustomerAccountsProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = {
                "com.kodilla.microservices:accounts:+:stubs:9000"
        }
)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class AccountsProviderTest {
    @Autowired
    private CustomerAccountsProvider accountsProvider;

    @Test
    void findCustomerAccounts() {
        //Given
        Long customerId = 1L;

        //When
        List<AccountSnapshot> accounts = accountsProvider.getCustomerAccounts(customerId);

        //Then
        assertEquals(1, accounts.size());
        assertEquals(95213, accounts.get(0).getId());
        assertEquals("08897810189710581776778244", accounts.get(0).getNrb());
        assertEquals("PLN", accounts.get(0).getCurrency());
    }

}
