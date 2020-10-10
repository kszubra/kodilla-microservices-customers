package com.kodilla.microservices.customers.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CustomerResponse {

    private Long id;

    private String firstName;

    private String lastName;
}
