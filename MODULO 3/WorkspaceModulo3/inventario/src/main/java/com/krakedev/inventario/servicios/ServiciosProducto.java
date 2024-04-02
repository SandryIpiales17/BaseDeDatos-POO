package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto producto) {
		System.out.println("Producto Insertado >>>>>"+producto);
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("ACTUALIZANDO PRODUCTO >>>>>>"+producto);
	}
	
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> productos= new ArrayList<Producto>();
		productos.add(new Producto("25","Ritz",new Categoria(1,"Snacks"),0.35,24));
		productos.add(new Producto("26","Deja",new Categoria(3,"Limpieza"),1.50,12));
		productos.add(new Producto("27","Cafe",new Categoria(2,"Diario"),3.50,10));
		return productos;
	}
	
	
}
