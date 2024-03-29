package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class ConexionBDD {
	private final static String DRIVER="org.postgresql.Driver";
	private final static String URL = "jdbc:postgresql://localhost:5432/BDKrakeDev";
	private final static String USUARIO="postgres";
	private final static String CLAVE="usuario";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);

	
	public static Connection conectar() throws Exception {
		//establecer la conexion
		Connection connection=null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,USUARIO,CLAVE);
			LOGGER.debug("Conexion Exitosa");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			LOGGER.error("Error de infraestructura");
			throw new Exception("Error de infraestructura");
		} catch (SQLException e) {
			LOGGER.error("Error al conectarse, revise usuario y clave");
			throw new Exception("Error al conectarse, revise usuario y clave");

		}
		return connection;
	
	}
}
