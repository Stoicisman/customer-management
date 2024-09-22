package com.example.customer_management;

import com.example.customer_management.entities.Customer;
import com.example.customer_management.exceptions.ResourceNotFoundException;
import com.example.customer_management.repositories.CustomerRepository;
import com.example.customer_management.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTests {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    public CustomerServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer(1L, "ANASSBD", "anassbd@example.com", "555-1234", "456 fhjh St");
        when(repository.save(customer)).thenReturn(customer);

        Customer createdCustomer = service.createCustomer(customer);
        assertEquals("ANASSBD", createdCustomer.getName());
        verify(repository, times(1)).save(customer);
    }

    @Test
    public void testGetCustomerByIdFound() {
        Customer customer = new Customer(1L, "ANASSBD", "anassbd@example.com", "555-1234", "456 fhjh St");
        when(repository.findById(1L)).thenReturn(Optional.of(customer));

        Optional<Customer> foundCustomer = service.getCustomerById(1L);
        assertTrue(foundCustomer.isPresent());
        assertEquals("ANASSBD", foundCustomer.get().getName());
    }

    @Test
    public void testGetCustomerByIdNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            service.getCustomerById(1L);
        });
        assertEquals("Customer not found for id: 1", exception.getMessage());
    }
}
