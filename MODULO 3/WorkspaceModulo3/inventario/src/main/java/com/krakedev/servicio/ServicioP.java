package com.krakedev.servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
@Path("clientes")

public class ServicioP {

	@Path("m1")
	@GET
	public String saludar() {
		return "Hola mundo Rest Web Services" ;
	}
	
	
}
