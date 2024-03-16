package com.turkcell.Abstract;

import com.turkcell.entities.Customer;

import java.net.MalformedURLException;

public interface ICustomerService {
    void save(Customer customer) throws MalformedURLException;

}
