package com.kodilla.microservices.customers.service.interfaces.providers;

import com.kodilla.microservices.customers.api.snapshot.CardSnapshot;

import java.util.List;

public interface CustomerCardsProvider {
    List<CardSnapshot> getCustomerCards(Long customerId);
}
