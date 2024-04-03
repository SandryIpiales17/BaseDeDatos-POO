package com.krakedev.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakeDevException;
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
		Cliente cliente= new Cliente("1712536586","Santiago",3);
		return cliente;
	}
	
	@Path("insertar")
	@POST
	//Recibe un cliente en formato Json 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente cliente) {
		System.out.println(">>>>>>"+cliente);
		ClienteBDD cli= new ClienteBDD();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("act")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO CLIENTE>>>>>>"+cliente);
		ClienteBDD cli= new ClienteBDD();
		try {
			cli.actualizar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		ClienteBDD cli= new ClienteBDD();
		ArrayList<Cliente> clientes= null;
		try {
			clientes=cli.recuperarTodos();
			return Response.ok(clientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}			

	}
	
	//buscarPorCedula/121313
	
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
		ClienteBDD cli= new ClienteBDD();
		Cliente cliente= null;
		try {
			cliente=cli.buscarPorPK(cedula);
			return Response.ok(cliente).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}			

	}
	
	@Path("buscarPorNumHijos/{numHijosParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNumHijod(@PathParam("numHijosParam") int numHijos){
		ClienteBDD cli= new ClienteBDD();
		ArrayList<Cliente> clientes= null;
		try {
			clientes=cli.buscarPorNumHijos(numHijos);
			return Response.ok(clientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}			

	}
	
}
