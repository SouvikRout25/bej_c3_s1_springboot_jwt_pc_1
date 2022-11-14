package com.example.practice.repository;

import com.example.practice.domain.Customer;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Integer, SecurityProperties.User> {
    Customer findByCustomerNameAndCustomerPassword(String customerName,String customerPassword);
}
