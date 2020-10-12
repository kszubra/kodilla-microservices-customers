package com.kodilla.microservices.customers.api.response;

import com.kodilla.microservices.customers.api.snapshot.AccountSnapshot;
import com.kodilla.microservices.customers.api.snapshot.CardSnapshot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProductsResponse {

    private Long customerId;

    private String fullName;

    private List<AccountSnapshot> accounts;

    private List<CardSnapshot> cards;
}
