package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
	public void metodo1() {
		String a= null;
		a.substring(0);
		//NPE Ubchecked : No te exige la excepciòn 
	}
	
	public void metodo2() {
		File f= new File("archivo1.txt");
		//Opcion 1: Envolver en Try - Catch(Se hace cargo )
		try {
			f.createNewFile();//IOE - CHECKED : Es obligatoria y te genera error de compilacion directo. 
		}catch(IOException io) {
			System.out.println("error");
		}
	}
	//se propoga sin hacerse cargo 
	public void metodo3() throws IOException{
		File f= new File("archivo1.txt");
		f.createNewFile();//IOE - CHECKED : Es obligatoria y te genera error de compilacion directo. 
	}
	//4 se puede hacer cargo de la excepcion o propagarla
	public void metodo4() {
		//metodo3();
	}
}
