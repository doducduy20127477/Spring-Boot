package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();
    List<Account> findAccounts (boolean tripWired);

    void addAccount(Account account);
    public String getName ();

    public void setName (String name);

    public String getServiceCode ();

    public void setServiceCode (String serviceCode);


}
