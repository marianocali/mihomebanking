package com.mybank.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class CuentaCorriente extends Cuenta {
	private double sobregiro;

	public CuentaCorriente() {
	}

	public CuentaCorriente(double saldoInicial, double sobregiro) {
		super(saldoInicial);
		this.sobregiro = sobregiro;
	}

	public CuentaCorriente(double saldoInicial) {
		super(saldoInicial);
		sobregiro = 0;
	}

	public void cargarCuentaCorriente(String nroCuentaCorriente) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		String sql = "SELECT * FROM CUENTAS WHERE NUMERO = '" + nroCuentaCorriente
				+ "'";

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				this.setNumero(Integer.parseInt(rs.getString(1)));
				this.setSaldo(Double.parseDouble(rs.getString(4)));
				this.setSobregiro(Double.parseDouble(rs.getString(5)));
			}
			rs.close();
			s.close();
			con.close();
			System.out.println(this);
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	}

	public boolean extraccion(double monto) {
		// double sobregiroRequerido = 0;
		boolean isOk = false;

		if (getSaldo() + getSobregiro() >= monto) {
			isOk = true;
			saldo = saldo - monto;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("JDBC driver loaded");
			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
			}

			String sql = "UPDATE CUENTAS " + " SET SALDO = '" + saldo
					+ "' WHERE NUMERO = '" + this.numero + "'";

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

				Statement s = con.createStatement();
				s.executeUpdate(sql);
				s.close();
				con.close();

			} catch (SQLException e) {
			} catch (Exception e) {
			}
		} else {
			// mostrar mensaje saldo insuficiente.

		}
		return isOk;
	}

	public double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(double sobregiro) {
		this.sobregiro = sobregiro;
	}
	
	public String toString (){
		String datosCuentaCorriente = "";
		datosCuentaCorriente = this.numero + " " + this.saldo + " " + this.sobregiro;
		return datosCuentaCorriente;
	}

}
