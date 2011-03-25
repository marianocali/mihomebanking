package com.mybank.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidaLoginBean 
{
	private boolean estaLogueado = false;

	public ValidaLoginBean()
	{
		
	}

	public  boolean isEstaLogueado() {
		return estaLogueado;
	}

	public  void setEstaLogueado(boolean estaLogueado) {
		this.estaLogueado = estaLogueado;
	}

	
	public  String getIdCliente(String userName) {
		String idCliente = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement s = con.createStatement();
			String sql = "SELECT ID FROM CLIENTES" + " WHERE USUARIO='"
					+ userName + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) 
			{
				idCliente = rs.getString(1);
				rs.close();
				s.close();
				con.close();
				setEstaLogueado(true);
				return idCliente;
			}
			rs.close();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return idCliente;
	}

	// retorna True si el cliente se logueo correctamente
	public boolean login(String userName, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement s = con.createStatement();
			String sql = "SELECT NOMBRE FROM CLIENTES" + " WHERE USUARIO='"
					+ userName + "'" + " AND PASSWORD='" + password + "'";

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				rs.close();
				s.close();
				con.close();
				setEstaLogueado(true);
				return true;				
			}
			rs.close();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return false;
	}


	
}
