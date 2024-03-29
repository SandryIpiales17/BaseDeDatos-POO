package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;
//System.out.println solo se va a poder usar en los tests

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	public static void insertar(Persona persona) throws Exception{
		Connection con= null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar >>>" + persona);
		try {
			//Al abrir una conexion es importante cerrarlo como se explico en excepciones
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("insert into personas(cedula,nombre, apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada, fecha_nacimiento, hora_nacimiento )"
					+ "			values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,persona.getCedula());
			ps.setString(2,persona.getNombre());
			ps.setString(3,persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5,persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			//Money
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new Time(persona.getHoraNacimiento().getTime()));
			ps.executeUpdate();
		}catch(Exception e) {
			//Muestra el error al usuario
			//System.out.println(e.getMessage());En lugar del mensaje exception 
			//Usar Sys soslo en Test
		
			//loggear el error
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		}finally {
			//cerramos conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
				//System.out.println("Error de infraestructura");

			}
		}
		
	}
	public static void actualizar(Persona persona) throws Exception{
		Connection con= null;
		PreparedStatement ps;
		LOGGER.trace("Persona a modificar >>>" + persona);
		try {
			//Al abrir una conexion es importante cerrarlo como se explico en excepciones
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("UPDATE personas SET nombre=?, apellido=? where cedula=?");
			ps.setString(1,persona.getNombre());
			ps.setString(2,persona.getApellido());
			ps.setString(3,persona.getCedula());
			ps.executeUpdate();
		}catch(Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		}finally {
			//cerramos conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");

			}
		}
	}
	public static void eliminar(String cedula) throws Exception{
		Connection con= null;
		PreparedStatement ps;
		LOGGER.trace("Persona a Eliminar >>>" + cedula);
		try {
			//Al abrir una conexion es importante cerrarlo como se explico en excepciones
			con=ConexionBDD.conectar();
			ps=con.prepareStatement("delete from personas where cedula=?");
			ps.setString(1,cedula);
			ps.executeUpdate();
		}catch(Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		}finally {
			//cerramos conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");

			}
		}
	}
}
