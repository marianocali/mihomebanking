package com.mybank.domain;

public class CajaDeAhorro extends Cuenta {
	private double tasaDeInteres;

	public CajaDeAhorro(double saldoInicial, double tasaDeInteres) {
		super(saldoInicial);
		this.tasaDeInteres = tasaDeInteres;
	}

	public void extraccion(double monto) throws SobregiroException {
		if (saldo > monto) {
			saldo -= monto;
		} else {
			throw new SobregiroException(
					"Fondos insuficientes para la extracción requerida ", monto
							- saldo);
		}
	}

}
