package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.snapshot.CardSnapshot;
import com.kodilla.microservices.customers.connector.CardsConnector;
import com.kodilla.microservices.customers.service.interfaces.providers.CustomerCardsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleCardsProvider implements CustomerCardsProvider {

    private final CardsConnector cardsConnector;

    @Override
    public List<CardSnapshot> getCustomerCards(Long customerId) {
        return cardsConnector.getCards(customerId).getCards();
    }
}
