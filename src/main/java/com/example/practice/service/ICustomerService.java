package com.example.practice.service;

import java.util.List;
import com.example.practice.domain.Customer;
import com.example.practice.exception.CustomerAlreadyExistException;
import com.example.practice.exception.CustomerNotFoundException;

public interface ICustomerService {
    Customer addCustomer(Customer customer) throws CustomerAlreadyExistException;
    List<Customer> getAllCustomers();
    Customer findByCustomerNameAndCustomerPassword(String customerName,String customerPassword) throws CustomerNotFoundException;
    boolean deleteCustomer(int customerId) throws CustomerNotFoundException;
}
