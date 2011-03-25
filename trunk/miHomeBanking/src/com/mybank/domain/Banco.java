package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

public class Banco
{
    private static List <ClienteBean> clientes;

   static
   {
       clientes = new ArrayList <ClienteBean>(10);
   }

   private Banco()
   {

   }

   public static void addCustomer(String f, String l)
   {
	   ClienteBean c = new ClienteBean();
       clientes.add(c);
   }

   public static int getNumOfCustomers()
   {
       return clientes.size();
   }

   public static ClienteBean getClienteBean(int index)
   {
       if(index < clientes.size())
       {
           return clientes.get(index);
       }
       else
       {
           return null;
       }
   }
}
