package com.mybank.report;

import com.mybank.domain.*;

public class CustomerReport {

  private Banco bank;

  public CustomerReport() {
  }

  public Banco getBank() {
    return bank;
  }

  public void setBank(Banco bank) {
    this.bank = bank;
  }

  public void generateReport() {

    // Print report header
    System.out.println("\t\t\tCUSTOMERS REPORT");
    System.out.println("\t\t\t================");

    // For each customer...
    for ( int cust_idx = 0;
          cust_idx < Banco.getNumOfCustomers();
          cust_idx++ ) {
      Customer customer = Banco.getCustomer(cust_idx);

      // Print the customer's name
      System.out.println();
      System.out.println("Customer: "
                         + customer.getLastName() + ", "
                         + customer.getFirstName());

      // For each account for this customer...
      for ( int acct_idx = 0;
            acct_idx < customer.getNumOfAccounts();
            acct_idx++ ) {
        Cuenta account = customer.getAccount(acct_idx);
        String  account_type = "";

        // Determine the account type
        /*** Use the instanceof operator to test what type of account
        **** we have and set account_type to an appropriate value, such
        **** as "Savings Account" or "Checking Account". ***/
	// YOUR CODE HERE

        if (account instanceof CajaDeAhorro)
        {
            account = (CajaDeAhorro) account;
            account_type = "SavingsAccount";
        }
        else
        {
            account = (CuentaCorriente) account;
            account_type = "CheckingAccount";
        }
        // Print the current balance of the account
        /*** Print out the type of account and the balance. ***/
	// YOUR CODE HERE
        System.out.print(account_type + " ");
        System.out.println(account.getBalance());
      }
    }
  }
}
