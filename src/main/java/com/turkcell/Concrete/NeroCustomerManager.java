package com.turkcell.Concrete;

import com.turkcell.Abstract.BaseCustomerManager;
import com.turkcell.Abstract.ICustomerCheckService;
import com.turkcell.entities.Customer;

import java.net.MalformedURLException;

public class NeroCustomerManager extends BaseCustomerManager {


    private final ICustomerCheckService _customerCheckService;

    public NeroCustomerManager(ICustomerCheckService customerCheckService) {
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
