package com.example.practice.service;

import com.example.practice.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(Customer customer);
}