package com.kodilla.microservices.customers.service;

import com.kodilla.microservices.customers.api.request.CustomerCreateRequest;
import com.kodilla.microservices.customers.api.response.CustomerResponse;
import com.kodilla.microservices.customers.api.snapshot.CustomerSnapshot;
import com.kodilla.microservices.customers.domain.model.Customer;
import com.kodilla.microservices.customers.domain.repository.CustomerRepository;
import com.kodilla.microservices.customers.service.interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class RepositoryCustomerService implements CustomerService {

    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    @Override
    @Transactional
    public Long createCustomer(CustomerCreateRequest request) {
        log.debug("Creating new user with email: {}", MaskUtils.maskEmail(request.getEmail()));
        Long id = repository.save(mapper.mapToEntity(request)).getCustomerId();
        log.info("Added customer with id: {}", id);
        return id;
    }

    @Override
    public CustomerResponse getCustomerResponse(Long customerId) {
        log.debug("Getting customer response for id: {}", customerId);
        return mapper.mapToResponse(getById(customerId));
    }

    @Override
    public CustomerSnapshot getCustomerSnapshot(Long customerId) {
        log.debug("Getting customer snapshot with id: {}", customerId);
        return mapper.mapToSnapshot(getById(customerId));
    }

    private Customer getById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
