package com.krakedev.estaticos;

public class Calculos {
	//atributo final para constante, hace que 
	//el valor no se pueda cambiar 
	private final double iva = 12;
	
	public double calcularIva(double monto) {
		return monto*iva/100;
	}
	
	
}
