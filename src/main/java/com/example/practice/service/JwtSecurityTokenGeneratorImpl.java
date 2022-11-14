package com.example.practice.service;

import com.example.practice.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtSecurityTokenGenerator implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Customer customer) {
        String jwToken = null;
        jwToken = Jwts.builder()
                .setSubject(customer.getCustomerName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();
        Map<String, String> map = new HashMap<>();
        map.put("token",jwToken);
        map.put("message","User logged in!!");
        return map;
    }
}