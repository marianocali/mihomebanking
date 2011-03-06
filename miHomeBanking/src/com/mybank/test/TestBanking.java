package com.mybank.test;

import com.mybank.domain.*;

public class TestBanking
{

  public static void main(String[] args)
  {
    Customer customer;      // lo usa para agregar  y recorrer cada cliente
    Account  account;       // lo usa para leer todas las cuentas

    // Create two customers and their accounts
    Bank.addCustomer("Jane", "Simms");          //agrega un cte
    customer = Bank.getCustomer(0);             //lo lee y almacena en customer
    customer.addAccount(new SavingsAccount(500.00, 0.05));
    //le agrega cuentas
    customer.addAccount(new CheckingAccount(200.00, 500.00));
    //agrega un nuevo cliente
    Bank.addCustomer("Owen", "Bryant");
    //lo lee
    customer = Bank.getCustomer(1);
    //le agrega una cuenta
    customer.addAccount(new SavingsAccount(200.00, 0.03));

    // Test the checking account of Jane Simms (with overdraft protection)
    //lee el primer cliente
    customer = Bank.getCustomer(0);
    // almacena en account su segunda cuenta
    account = customer.getAccount(1);
    //muestras sus datos
    System.out.println("Customer [" + customer.getLastName()
		       + ", " + customer.getFirstName() + "]"
		       + " has a checking balance of "
		       + account.getBalance()
			 + " with a 500.00 overdraft protection.");
    try
    {
      // intenta agregar y extraer dinero
      System.out.println("Checking Acct [Jane Simms] : withdraw 150.00");
      account.withdraw(150.00);
      System.out.println("Checking Acct [Jane Simms] : deposit 22.50");
      account.deposit(22.50);
      System.out.println("Checking Acct [Jane Simms] : withdraw 147.62");
      account.withdraw(147.62);
      System.out.println("Checking Acct [Jane Simms] : withdraw 470.00");
      account.withdraw(470.00);
    }
    catch (OverdraftException e1)
    {
      // si no hay suficiente dinero muestra el mensaje de la excepcion
      System.out.println("Exception: " + e1.getMessage()
			 + "   Deficit: " + e1.getDeficit());
    }
    finally
    {
        //muestra el cliente y su balance final.
      System.out.println("Customer [" + customer.getLastName()
			 + ", " + customer.getFirstName() + "]"
			 + " has a checking balance of "
			 + account.getBalance());
    }
    System.out.println();

    // Test the checking account of Owen Bryant (without overdraft protection)
    customer = Bank.getCustomer(1);
    account = customer.getAccount(0);
    System.out.println("Customer [" + customer.getLastName()
		       + ", " + customer.getFirstName() + "]"
		       + " has a savings balance of "
		       + account.getBalance());
    try
    {
      System.out.println("Savings Acct [Owen Bryant] : withdraw 100.00");
      account.withdraw(100.00);
      System.out.println("Savings Acct [Owen Bryant] : deposit 25.00");
      account.deposit(25.00);
      System.out.println("Savings Acct [Owen Bryant] : withdraw 175.00");
      account.withdraw(175.00);
    }
    catch (OverdraftException e1)
    {
      System.out.println("Exception: " + e1.getMessage()
			 + "   Deficit: " + e1.getDeficit());
    }
    finally
    {
      System.out.println("Customer [" + customer.getLastName()
			 + ", " + customer.getFirstName() + "]"
			 + " has a savings balance of "
			 + account.getBalance());
    }
  }
}
