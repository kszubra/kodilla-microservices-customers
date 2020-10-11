package com.kodilla.microservices.customers.connector;

import com.kodilla.microservices.customers.api.response.CustomerCardsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@FeignClient(name = "cards", fallback = CardsConnectorFallback.class)
public interface CardsConnector {

    @GetMapping("/v1/cards")
    CustomerCardsResponse getCards(@RequestParam("customerId") Long customerId);
}

@Slf4j
@Component
class CardsConnectorFallback implements CardsConnector {
    @Override
    public CustomerCardsResponse getCards(Long customerId) {
        log.warn("Can not get cards for customer with id: {}", customerId);
        return new CustomerCardsResponse(Collections.emptyList());
    }
}
