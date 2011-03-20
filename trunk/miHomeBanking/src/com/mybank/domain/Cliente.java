/*
 *  cuentaCorrienteNro y cajaDeAhorroNro fijarse si los hacemos nros o String
 */

package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class Cliente {
	String id;
	String apellido;
	String nombre;
	String documento;
	CajaDeAhorro cajaDeAhorro; // un cliente puede tener hasta una caja de
								// ahorro
	CuentaCorriente cuentaCorriente;

	public Cliente(String apellido, String nombre, String documento) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.documento = documento;
	}

	public String toString() {
		return "ID: " + id + ", Apellido: " + apellido + ", Nombre: " + nombre
				+ ", Documento: " + documento + ", Caja de Ahorro: "
				+ cajaDeAhorro + ", Cuenta Corriente: " + cuentaCorriente
				+ "\n ";
	};

	public Cliente() {
	}

	public Cliente(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public CajaDeAhorro getCajaDeAhorro() {
		return cajaDeAhorro;
	}

	public void setCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
		this.cajaDeAhorro = cajaDeAhorro;
	}

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public void cargarCliente(int idCliente) {
		this.setId(Integer.toString(idCliente));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}

		String sql = "SELECT * FROM CLIENTES WHERE ID = '" + idCliente + "'";

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				this.setApellido(rs.getString(2));
				this.setNombre(rs.getString(3));
				this.setDocumento(rs.getString(4));
				String nroCajaDeAhorro = rs.getString(5);
				if (nroCajaDeAhorro != null) {
					cajaDeAhorro = new CajaDeAhorro();
					cajaDeAhorro.cargarCajaAhorro(nroCajaDeAhorro);
				}
				String nroCuentaCorriente = rs.getString(6);
				if (nroCajaDeAhorro != null) {
					cuentaCorriente = new CuentaCorriente();
					cuentaCorriente.cargarCuentaCorriente(nroCuentaCorriente);
				}
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	}
}
