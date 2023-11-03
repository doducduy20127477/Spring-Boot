package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts () {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts (boolean tripWired) {

        if(tripWired) {
            throw new RuntimeException("No soup for you!");
        }
        List<Account> accounts = new ArrayList<>();
        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platium");
        Account temp3 = new Account("Luca", "Gold");

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

    @Override
    public void addAccount (Account account) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public String getName () {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName (String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode () {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode (String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
