// MAXIMIZAR LA VENTANA SHIFT + ESC
package com.mybank.domain;


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

    public void deposito (double monto)
    {
        saldo = saldo + monto;       
    }

    public abstract void extraccion (double monto) throws SobregiroException;
    
}
