package com.mybank.domain;

import java.sql.*;

public class CajaDeAhorro extends Cuenta {
	private double tasaDeInteres;

	public CajaDeAhorro(double saldoInicial, double tasaDeInteres) {
		super(saldoInicial);
		this.tasaDeInteres = tasaDeInteres;
	}
	public CajaDeAhorro() 
	{
	}


	
	public void cargarCajaAhorro(String nroCajaAhorro)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		String sql = "SELECT * FROM CUENTAS WHERE NUMERO = '" + nroCajaAhorro + "'";

		try 
		{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) 
			{
				this.setNumero(Integer.parseInt(rs.getString(1)));
				this.setSaldo(Double.parseDouble(rs.getString(4)));				
			}
			rs.close();
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
	
	 public void extraccion(double monto)
		{
		 	if (saldo > monto) 
		 	{				
				saldo = saldo - monto;		 	
				try 
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("JDBC driver loaded");
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
		 	else
		 	{
		 		//mostrar mensaje saldo insuficiente.
		 		
		 	}
		}

}
