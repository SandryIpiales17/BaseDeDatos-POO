package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;
//System.put.println solo se va a poder usar en los tests
public class TestAdminPersona {
	public static void main(String[] args) {
		EstadoCivil ec=new EstadoCivil("U","UnionLibre");
		Persona p= new Persona("1736232384","Julio","Jaramillo",ec);
		try {
			Date fechaNac= Convertidor.convertirFecha("1990/11/20");
			Date horaNac= Convertidor.convertirHora("09:23");
						
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimiento(horaNac);
			p.setCantidadAhorrada(new BigDecimal(1230.45));
			p.setNumeroHijos(50);
			AdminPersonas.insertar(p);
		} catch (Exception e) {
			//No Loggeamos el error 
			//e.printStackTrace();
			System.out.println("Error en el sistema: "+e.getMessage());
		}
		
		
	}
}
