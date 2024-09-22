package com.example.customer_management.services;

import com.example.customer_management.entities.Customer;
import com.example.customer_management.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Customer customer = new Customer();
        customer.setName("Anass");
        customer.setEmail("Anass@example.com");
        customer.setPhone("555-1234");
        customer.setAddress("456 Elm St");
        customerRepository.save(customer);
    }
}
