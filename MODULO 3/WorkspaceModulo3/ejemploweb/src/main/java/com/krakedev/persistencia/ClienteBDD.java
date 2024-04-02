package com.krakedev.persistencia;

import java.sql.Connection;

import com.krakedev.entidades.Cliente;
import com.krakedev.utils.ConexionBDD;

public class ClienteBDD {
	public void insertar(Cliente cliente) {
		Connection con = ConexionBDD.obtenerConexion();
		if(con!= null) {
			System.out.println("CONECTADO");
		}else {
			System.out.println("ERROR AL OBTENER CONEXION");
		}
	}
}