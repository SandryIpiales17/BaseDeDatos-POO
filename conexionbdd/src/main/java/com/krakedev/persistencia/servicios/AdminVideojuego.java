package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.VideoJuegos;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminVideojuego {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	public static ArrayList<VideoJuegos> buscarPorNombre(String nombreBusqueda) throws Exception{
		ArrayList<VideoJuegos> videojuegos= new ArrayList<VideoJuegos>();
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("select * from videojuegos where nombre like ?");
			ps.setString(1, "%"+nombreBusqueda+"%");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nombre= rs.getString("nombre");
				int codigo= rs.getInt("codigo");
				String descripcion= rs.getString("descripcion");
				VideoJuegos vj = new VideoJuegos();
				vj.setNombre(nombre);
				vj.setCodigo(codigo);
				vj.setDescripcion(descripcion);
				videojuegos.add(vj);
			}
			} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");

		}finally {
			//cerramos conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");

			}
		}
		
		return videojuegos;
	}
	
	public static VideoJuegos buscarCodigo(int codigoBusqueda) throws Exception{
		VideoJuegos videojuegos= new VideoJuegos();
		Connection con= null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con= ConexionBDD.conectar();
			ps=con.prepareStatement("select * from videojuegos where codigo= ?");
			ps.setInt(1, codigoBusqueda);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				String nombre= rs.getString("nombre");
				int codigo= rs.getInt("codigo");
				String descripcion= rs.getString("descripcion");
				videojuegos.setNombre(nombre);
				videojuegos.setCodigo(codigo);
				videojuegos.setDescripcion(descripcion);
				
			}else {
				return null;
			}
			} catch (Exception e) {
			LOGGER.error("Error al consultar por codigo", e);
			throw new Exception("Error al consultar por codigo");

		}finally {
			//cerramos conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");

			}
		}
		
		return videojuegos;
	}

}
