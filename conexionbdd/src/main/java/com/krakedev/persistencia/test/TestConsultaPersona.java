package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaPersona {

	public static void main(String[] args) {
		try {
			ArrayList<Persona> personas=AdminPersonas.buscarPorNombre("Santiago");
			System.out.println(personas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
