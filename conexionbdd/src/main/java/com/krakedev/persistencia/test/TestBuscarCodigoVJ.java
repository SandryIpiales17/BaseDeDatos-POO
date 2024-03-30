package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.VideoJuegos;
import com.krakedev.persistencia.servicios.AdminVideojuego;

public class TestBuscarCodigoVJ {

	public static void main(String[] args) {
		try {
			VideoJuegos vj=AdminVideojuego.buscarCodigo(1456);
			System.out.println(vj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
