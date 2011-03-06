package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

public class Banco
{
    private static List <Customer> customers;

   static
   {
       customers = new ArrayList <Customer>(10);
   }

   private Banco()
   {

   }

   public static void addCustomer(String f, String l)
   {
       Customer c = new Customer(f,l);
       customers.add(c);
   }

   public static int getNumOfCustomers()
   {
       return customers.size();
   }

   public static Customer getCustomer(int index)
   {
       if(index < customers.size())
       {
           return customers.get(index);
       }
       else
       {
           return null;
       }
   }
}
