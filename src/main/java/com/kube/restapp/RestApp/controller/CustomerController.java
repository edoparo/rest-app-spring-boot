package com.kube.restapp.RestApp.controller;

import java.util.List;

import com.kube.restapp.RestApp.bean.Customer;
import com.kube.restapp.RestApp.exceptions.CustomerNotFoundException;
import com.kube.restapp.RestApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.oas.annotations.EnableOpenApi;

@RestController
@EnableOpenApi
class CustomerController {
    
    @Autowired
    private CustomerRepository repository;

    // Aggregate root

    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

/*
    // Single item
    @GetMapping("/Customers/{id}")
    Customer one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/Customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {

        return repository.findById(id)
                .map(Customer -> {
                    Customer.setName(newCustomer.getName());
                    Customer.setRole(newCustomer.getRole());
                    return repository.save(Customer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @DeleteMapping("/Customers/{id}")
    void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }


 */
}