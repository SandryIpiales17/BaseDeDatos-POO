package com.krakedev.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.entidades.Cliente;
import com.krakedev.persistencia.ClienteBDD;

@Path("customers")
public class ServicioClientes {
	@Path("m1")
	@GET
	public String saludar() {
		return "Hola mundo Rest Web Services" ;
	}
	
	
	@Path("mbuscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//Devulve un cliente en formato Json 
	public Cliente buscar() {
		Cliente cliente= new Cliente("1712536586","Santiago");
		return cliente;
	}
	
	@Path("insertar")
	@POST
	//Recibe un cliente en formato Json 
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Cliente cliente) {
		System.out.println(">>>>>>"+cliente);
		ClienteBDD cli= new ClienteBDD();
		cli.insertar(cliente);
		
	}
	
	@Path("act")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO CLIENTE>>>>>>"+cliente);
	}
	
}
