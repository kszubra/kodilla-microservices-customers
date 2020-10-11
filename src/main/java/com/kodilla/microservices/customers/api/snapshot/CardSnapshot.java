package com.kodilla.microservices.customers.api.snapshot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CardSnapshot {

    private Long cardId;

    private String cardNumber;

    private Long account;

    private String cardType;

    private String cardProvider;

    private LocalDate expirationDate;

    private int cvvNumber;

    private Boolean isActive;
}
