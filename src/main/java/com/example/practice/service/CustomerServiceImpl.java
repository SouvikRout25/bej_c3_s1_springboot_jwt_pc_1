package com.example.practice.service;

import com.example.practice.domain.Customer;
import com.example.practice.exception.CustomerAlreadyExistException;
import com.example.practice.exception.CustomerNotFoundException;
import com.example.practice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistException {
        if(customerRepository.findById(customer.getCustomerId()).isPresent()){
            throw new CustomerAlreadyExistException();
        }
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerNameAndCustomerPassword(String customerName, String customerPassword) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByCustomerNameAndCustomerPassword(customerName,customerPassword);
        if(customer == null){
            throw new CustomerNotFoundException();
        }
        return customer;
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean flag = false;
        if(customerRepository.findById(customerId).isEmpty()){
            throw new CustomerNotFoundException();
        }
        else{
            customerRepository.deleteById(customerId);
            flag=true;
        }
        return flag;
    }
}