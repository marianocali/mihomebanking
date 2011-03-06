package com.mybank.test;
import java.sql.*;

public class DbConection
{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException
    {
        try
        {
           Class.forName("org.apache.derby.jdbc.ClientDriver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e);
        }
        String url = "jdbc:derby://localhost:1527/COFFEEBREAK";
        String query =  new String(
                         "SELECT * " +
                         "FROM COFFEES C " +
                         "JOIN SUPPLIERS S " +
                         "ON C.SUP_ID = S.SUP_ID " //+
                       //  "WHERE SUP_NAME LIKE 'Acme, Inc.'"
                         );
        try 
        {
        	// conexion en Netbeans
            // Connection con = DriverManager.getConnection(url,"hr","hrdznamo" );
            // conexion en Eclipse
            Connection con = DriverManager.getConnection(url);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Nombre del cafe | " + " precio | " + "sup id | " + "zip | ");
            while (rs.next())
            {
                String cofName = rs.getString("COF_NAME");
                float price = rs.getFloat("PRICE");
                String sup_id = rs.getString("SUP_ID");
                float zip = rs.getFloat("ZIP");
                System.out.println(cofName + "\t" + price + "\t " + sup_id +"\t "+ zip);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
   }
}
