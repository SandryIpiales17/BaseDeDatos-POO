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

public class InsertarRegistro {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/BDKrakeDev","postgres","usuario");
			System.out.println("conexión exitosa");
			//Tabla Empleado 
			ps=connection.prepareStatement("insert into empleado(codigo_empleado ,nombre,fecha,hora)"
					+ "			values(?,?,?,?)");
			ps.setInt(1,125);
			ps.setString(2,"Jessica Lopez");
			//Tabla Prestamo 
			ps2=connection.prepareStatement("insert into prestamo(cedula, monto, garante, fecha_prestamo,hora_prestamo)"
					+ "			values(?,?,?,?,?)");
			ps2.setString(1, "0106161210");
			//Money
			ps2.setBigDecimal(2, new BigDecimal(950));
			ps2.setString(3,"Mariana Guzman");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr="2022/03/22 08:05:04";
			String fechaPrestamoStr="2024/01/20 11:15:00";
			try {
				Date fecha=sdf.parse(fechaStr);
				Date fechaP=sdf.parse(fechaPrestamoStr);
				System.out.println("Fecha Empleado "+fecha);
				System.out.println("Fecha Prestamo "+fechaP);
				long fechaMilis=fecha.getTime();
				long fechaMilisP= fechaP.getTime();
				System.out.println(fechaMilis);
				System.out.println(fechaMilisP);
				//crea un java.sqlDate, partiendo de un java.util.Date
				java.sql.Date fechaSQL=new java.sql.Date(fechaMilis);
				java.sql.Date fechaSQLP= new java.sql.Date(fechaMilisP);
				System.out.println("Fecha Empleado "+fechaSQL);
				System.out.println("Fecha Prestamo "+fechaSQLP);
				Time timeSQL= new Time(fechaMilis);
				Time timeSQLP= new Time(fechaMilisP);
				System.out.println("Hora Empleado "+timeSQL);
				System.out.println("Hora Prestamo "+timeSQLP);
				
				ps.setDate(3, fechaSQL);
				ps.setTime(4, timeSQL);
				ps2.setDate(4, fechaSQLP);
				ps2.setTime(5, timeSQLP);
				
				
				ps.executeUpdate();
				ps2.executeUpdate();
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
