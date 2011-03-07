package com.mybank.domain;

import java.util.List;
import java.util.ArrayList;

public class Cliente {
	String id;
	String apellido;
	String nombre;
	String documento;
	String cajaDeAhorro;
	String cuentaCorriente;

	public Cliente(String apellido, String nombre, String documento) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.documento = documento;
	}
	
	public String toString ()
	{
		return "ID: "+  id + ", Apellido: " + apellido + ", Nombre: " + nombre + ", Documento: " + documento + ", Caja de Ahorro: " + cajaDeAhorro + ", Cuenta Corriente: " + cuentaCorriente + "\n ";
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

	public String getCajaDeAhorro() {
		return cajaDeAhorro;
	}

	public void setCajaDeAhorro(String cajaDeAhorro) {
		this.cajaDeAhorro = cajaDeAhorro;
	}

	public String getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(String cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

}
