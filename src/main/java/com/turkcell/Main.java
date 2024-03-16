package com.turkcell;

import com.turkcell.Abstract.BaseCustomerManager;
import com.turkcell.Adapters.MernisSoapService;
import com.turkcell.Concrete.CustomerCheckManager;
import com.turkcell.Concrete.NeroCustomerManager;
import com.turkcell.Concrete.StarbucksCustomerManager;
import com.turkcell.entities.Customer;

import java.net.MalformedURLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws MalformedURLException {

        Customer customer = new Customer();
        customer.setName("Mert");
        customer.setSurname("Kılınç");
        customer.setDateOfBirth(1999);
        customer.setNationalityId("11785912532");

        BaseCustomerManager starbucksManager = new StarbucksCustomerManager(new MernisSoapService());
        starbucksManager.save(customer);

        BaseCustomerManager neroManager = new NeroCustomerManager(new CustomerCheckManager());
        neroManager.save(customer);
    }



}