package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

public class Banco
{
    private static List <Cliente> clientes;

   static
   {
       clientes = new ArrayList <Cliente>(10);
   }

   private Banco()
   {

   }

   public static void addCustomer(String f, String l)
   {
       Cliente c = new Cliente();
       clientes.add(c);
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
