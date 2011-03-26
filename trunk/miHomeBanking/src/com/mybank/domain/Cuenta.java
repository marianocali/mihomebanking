// MAXIMIZAR LA VENTANA SHIFT + ESC
package com.mybank.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Cuenta
{
    protected double saldo;
    protected int numero;

    public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	protected Cuenta()
    {

    }

    protected Cuenta(double saldo)
    {
        this.saldo = saldo; 
    }

    public double getSaldo()
    {
        return saldo;
    }

//    public void deposito (double monto)
//    {
//        saldo = saldo + monto;       
//    }

    public void deposito(double monto)
	{
        saldo = saldo + monto;	
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.toString());
		}
		
		String sql = "UPDATE CUENTAS " +
					" SET SALDO = '" + saldo + 
					"' WHERE NUMERO = '" + this.numero + "'";

		try 
		{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();

			s.executeUpdate(sql);

			s.close();
			con.close();
			
		}
		catch (SQLException e) 
		{
		} 
		catch (Exception e) 
		{
		}
	}

    
    public abstract boolean extraccion (double monto) throws SobregiroException;
    
}
