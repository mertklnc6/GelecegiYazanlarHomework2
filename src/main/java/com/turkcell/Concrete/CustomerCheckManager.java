package com.turkcell.Concrete;

import com.turkcell.Abstract.ICustomerCheckService;
import com.turkcell.Abstract.ICustomerService;
import com.turkcell.entities.Customer;

public class CustomerCheckManager implements ICustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {
        return true;
    }

}
