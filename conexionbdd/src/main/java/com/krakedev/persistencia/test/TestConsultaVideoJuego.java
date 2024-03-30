package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.VideoJuegos;
import com.krakedev.persistencia.servicios.AdminVideojuego;

public class TestConsultaVideoJuego {

	public static void main(String[] args) {
		try {
			ArrayList<VideoJuegos> vj=AdminVideojuego.buscarPorNombre("Call");
			System.out.println(vj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
