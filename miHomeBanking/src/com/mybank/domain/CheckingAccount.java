
package com.mybank.domain;

public class CheckingAccount extends Account
{
    private double overdraftAmount;

    public CheckingAccount(double initBalance, double overdraft)
    {
        super(initBalance);
        overdraftAmount = overdraft;
    }

    public CheckingAccount(double initBalance)
    {
        super(initBalance);
        overdraftAmount = 0;
    }
    
    public void withdraw(double amt) throws OverdraftException
    {
        double overdraftNeeded = 0;
        if (getBalance() < amt)
        {
            overdraftNeeded = amt - balance;
            if(overdraftAmount < overdraftNeeded)
            {
                throw new OverdraftException("insuficient fonds for overdraft protection ", amt - balance);
            }
            else
            {
                balance = 0;
                overdraftAmount = overdraftAmount - overdraftNeeded;
            }
        }
        else
        {
            balance = balance - amt;          
        }
        
    }
}
