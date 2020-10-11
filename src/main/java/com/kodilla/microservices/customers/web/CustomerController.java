package com.kodilla.microservices.customers.web;

import com.kodilla.microservices.customers.api.request.CustomerCreateRequest;
import com.kodilla.microservices.customers.api.response.CustomerProductsResponse;
import com.kodilla.microservices.customers.api.response.CustomerResponse;
import com.kodilla.microservices.customers.service.interfaces.CustomerApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerApiService apiService;

    @GetMapping("/{customerId}")
    public CustomerResponse getCustomer(@PathVariable Long customerId) {
        return apiService.getCustomerResponse(customerId);
    }

    @PostMapping
    public Long createCustomer(@RequestBody CustomerCreateRequest request) {
        return apiService.createCustomer(request);
    }

    @GetMapping("/{customerId}/products")
    public CustomerProductsResponse getCustomerProducts(@PathVariable Long customerId) {
        return apiService.findCustomerProducts(customerId);
    }
}
