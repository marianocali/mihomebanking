package com.mybank.domain;

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

	public void extraccion(double monto) throws SobregiroException {
		// double sobregiroRequerido = 0;
		if (getSaldo() + getSobregiro() >= monto) {
			saldo = monto - saldo;
		} else {
			throw new SobregiroException(
					"Fondos insuficientes para la extracción requerida ", monto
							- saldo);
		}
	}

	public double getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(double sobregiro) {
		this.sobregiro = sobregiro;
	}
}
