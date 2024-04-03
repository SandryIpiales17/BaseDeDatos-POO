package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
import com.krakedev.utils.ConexionBDD;

public class ClienteBDD {
	public void insertar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		try {
			con=ConexionBDD.obtenerConexion();
			PreparedStatement ps= con.prepareStatement("insert into clientes(cedula,nombre,numeroHijos)"
					+ "values(?,?,?)");
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new KrakeDevException("Error al insertar el cliente");
		} catch (KrakeDevException e) {
			throw e;
		}
		
	}
	
	public void actualizar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement("UPDATE clientes SET apellido = ? WHERE cedula = ?");
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCedula());
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new KrakeDevException("Error al actualizar cliente" + e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
