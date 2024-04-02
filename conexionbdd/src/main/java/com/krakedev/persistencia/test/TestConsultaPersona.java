package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestConsultaPersona {

	public static void main(String[] args) {
		try {
			Date fechaNac= Convertidor.convertirFecha("2020/03/22");
						
			
			ArrayList<Persona> personas=AdminPersonas.buscarPorFecha(fechaNac);
			System.out.println(personas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
