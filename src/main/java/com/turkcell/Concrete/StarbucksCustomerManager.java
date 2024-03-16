package com.turkcell.Concrete;

import com.turkcell.Abstract.BaseCustomerManager;
import com.turkcell.Abstract.ICustomerCheckService;
import com.turkcell.entities.Customer;

import java.net.MalformedURLException;

public class StarbucksCustomerManager extends BaseCustomerManager {

    private ICustomerCheckService _customerCheckService;

    public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
        _customerCheckService = customerCheckService;
    }

    @Override
    public void save(Customer customer) throws MalformedURLException {
        if(_customerCheckService.checkIfRealPerson(customer)){
            super.save(customer);
        }
        else
            throw new RuntimeException("Not a valid person");

    }
}
