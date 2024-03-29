package com.krakedev.herencia;

public class Perro extends Animal {
	public Perro() {
		super();//Siempre se ejecuta aun q no este explicitamente
		System.out.println("Ejecutar constructor de Perro");
	}
	public void ladrar() {
		System.out.println("Perro Ladrando");
	}
	@Override
	public void dormir() {
		super.dormir();//Permite usar los  metodos del padre aun si esta sobreescrito
		System.out.println("Perro durmiendo--");
	}
}
