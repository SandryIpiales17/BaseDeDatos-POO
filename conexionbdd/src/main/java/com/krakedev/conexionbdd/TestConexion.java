package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDKrakeDev","postgres","usuario");
			System.out.println("conexión exitosa");
			ps=connection.prepareStatement("insert into personas(cedula,nombre, apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada, fecha_nacimiento, hora_nacimiento )"
					+ "			values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,"1989123892");
			ps.setString(2,"Marco");
			ps.setString(3,"Lima");
			ps.setString(4,"C");
			ps.setInt(5,3);
			ps.setDouble(6, 1.56);
			//Money
			ps.setBigDecimal(7, new BigDecimal(12.580));
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2020/03/22 10:05:04";
			try {
				Date fecha=sdf.parse(fechaStr);
				System.out.println(fecha);
				long fechaMilis=fecha.getTime();
				System.out.println(fechaMilis);
				//crea un java.sqlDate, partiendo de un java.util.Date
				java.sql.Date fechaSQL=new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);
				Time timeSQL= new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSQL);
				
				
				ps.executeUpdate();
				System.out.println("ejecuta insert");

				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
