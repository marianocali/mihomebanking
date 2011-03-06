package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

public class Customer
{
    private String firstName;
    private String lastName;
    private List <Account> accounts;

    Customer()
    {
        accounts = new ArrayList<Account>(10);
    }

    public Customer(String f, String l)
    {
        firstName = f;
        lastName  = l;
        accounts = new ArrayList<Account>(10);
    }

    public void addAccount (Account c)
    {
        accounts.add(c);
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Account getAccount(int index)
    {
        if(accounts.size()>= index )
        {
            return accounts.get(index);
        }
        else
        {
            return null;
        }
    }

    public int getNumOfAccounts()
    {
        return accounts.size();
    }
}
