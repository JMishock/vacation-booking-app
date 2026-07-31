package com.example.demo.config;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initCustomers(
            CustomerRepository customerRepository,
            DivisionRepository divisionRepository
    ) {
        return args -> {
            if (customerRepository.count() < 5) {

                Division division = divisionRepository
                        .findById(2L)
                        .orElse(null);

                customerRepository.save(createCustomer(
                        "John",
                        "Smith",
                        "123 Main Street",
                        "85001",
                        "555-111-1111",
                        division
                ));

                customerRepository.save(createCustomer(
                        "Sarah",
                        "Johnson",
                        "456 Desert Road",
                        "85002",
                        "555-222-2222",
                        division
                ));

                customerRepository.save(createCustomer(
                        "Michael",
                        "Brown",
                        "789 Canyon Drive",
                        "85003",
                        "555-333-3333",
                        division
                ));

                customerRepository.save(createCustomer(
                        "Emily",
                        "Davis",
                        "321 Valley Avenue",
                        "85004",
                        "555-444-4444",
                        division
                ));

                customerRepository.save(createCustomer(
                        "David",
                        "Wilson",
                        "654 Sunset Boulevard",
                        "85005",
                        "555-555-5555",
                        division
                ));
            }
        };
    }

    private Customer createCustomer(
            String firstName,
            String lastName,
            String address,
            String postalCode,
            String phone,
            Division division
    ) {
        Customer customer = new Customer();

        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setPostal_code(postalCode);
        customer.setPhone(phone);
        customer.setDivision(division);

        return customer;
    }
}