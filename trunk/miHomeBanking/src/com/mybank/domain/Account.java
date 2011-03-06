// MAXIMIZAR LA VENTANA SHIFT + ESC
package com.mybank.domain;


public class Account
{
    protected double balance;

    protected Account()
    {

    }

    protected Account(double d)
    {
        balance = d; 
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amt)
    {
        balance = balance + amt;       
    }

    public void withdraw(double amt) throws OverdraftException
    {
        if (balance > amt)
        {
            balance = balance - amt;            
        }
        else
        {
            throw new OverdraftException("Insuficient funds for withdraw", amt - balance);
        }
    }
}
