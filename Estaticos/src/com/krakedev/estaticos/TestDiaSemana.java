package com.krakedev.estaticos;

public class TestDiaSemana {
	public static void main(String[] args) {
		
		/*Acceso a Constante*/
		/*DiaSemana ds= new DiaSemana();
		int dia= ds.LUNES;
		System.out.println(dia);*/
		
		/*-----Constante Estatica---*/
		int dia = DiaSemana.LUNES;
		System.out.println(dia);
		
		int radio=10;
		double area=Math.PI*radio;
		System.out.println(area);
		
	}
}
