package com.kodilla.microservices.customers.api.snapshot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CustomerSnapshot {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private LocalDateTime createdAt;

    private boolean isActive;
}
