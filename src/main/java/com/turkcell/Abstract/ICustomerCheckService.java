package com.turkcell.Abstract;

import com.turkcell.entities.Customer;

import java.net.MalformedURLException;

public interface ICustomerCheckService {
    boolean checkIfRealPerson(Customer customer) throws MalformedURLException;
}
