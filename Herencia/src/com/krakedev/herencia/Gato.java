package com.krakedev.herencia;

public class Gato extends Animal{
	@Override
	public void dormir() {
		System.out.println("Gato Durmiendo");
	}
	
	public void maullar() {
		System.out.println("Gato maullando");
	}
	public void maullar(String adjetivo) {
		System.out.println("Gato maullando "+ adjetivo);
	}
}
