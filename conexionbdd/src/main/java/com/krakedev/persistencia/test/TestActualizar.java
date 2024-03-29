package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestActualizar {

	public static void main(String[] args) {
		EstadoCivil ec=new EstadoCivil("U","UnionLibre");
		Persona p= new Persona("1736232384","Eduardo","Jaramillo",ec);
		try {
			AdminPersonas.actualizar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());

		}
	}

}
	