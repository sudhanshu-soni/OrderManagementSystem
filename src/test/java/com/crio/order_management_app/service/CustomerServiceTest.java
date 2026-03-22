package com.crio.order_management_app.service;

import com.crio.order_management_app.model.Customer;
import com.crio.order_management_app.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    public CustomerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("John Doe");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        Customer created = customerService.createCustomer(customer);
        assertEquals("John Doe", created.getName());
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Optional<Customer> found = customerService.getCustomerById(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }
}
