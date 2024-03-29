package com.krakedev.excepciones;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		System.out.println("inicio");
		String a=null;
		try {
			System.out.println("ABRE LA CONEXION BDD");
			a.substring(3);
			System.out.println("fin");
		}catch(Exception ex) {
			System.out.println("entra al catch");
		}finally {
			System.out.println("ingresa al finally");
			System.out.println("CIERRA LA CONEXION");
		}
		System.out.println("Fuera del Catch");
		
	}
}
