package com.turkcell.Abstract;

import com.turkcell.entities.Customer;

import java.net.MalformedURLException;

public abstract class BaseCustomerManager implements ICustomerService{
    @Override
    public void save(Customer customer) throws MalformedURLException {
        System.out.println("Saved to db : " + customer.getName());
    }
}
