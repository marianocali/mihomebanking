package com.mybank.test;

import com.mybank.domain.*;
import com.mybank.report.*;

public class TestReport {

    public static void main(String[] args) {
        initializeCustomers();

        // run the customer report
        CustomerReport report = new CustomerReport();
        report.generateReport();
    }

    private static void initializeCustomers() {
        Customer customer;

        // Create several customers and their accounts
        Banco.addCustomer("Jane", "Simms");
        customer = Banco.getCustomer(0);
        customer.addAccount(new CajaDeAhorro(500.00, 0.05));
        customer.addAccount(new CuentaCorriente(200.00, 400.00));

        Banco.addCustomer("Owen", "Bryant");
        customer = Banco.getCustomer(1);
        customer.addAccount(new CuentaCorriente(200.00));

        Banco.addCustomer("Tim", "Soley");
        customer = Banco.getCustomer(2);
        customer.addAccount(new CajaDeAhorro(1500.00, 0.05));
        customer.addAccount(new CuentaCorriente(200.00));

        Banco.addCustomer("Maria", "Soley");
        customer = Banco.getCustomer(3);
        // Maria and Tim have a shared checking account
        customer.addAccount(Banco.getCustomer(2).getAccount(1));
        customer.addAccount(new CajaDeAhorro(150.00, 0.05));
    }
}
