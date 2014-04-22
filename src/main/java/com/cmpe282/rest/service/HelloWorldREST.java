package com.cmpe282.rest.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.cmpe282.rest.dao.DbConnection;

@Path("/helloWorldREST")
public class HelloWorldREST {

	@GET
	@Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,
			@DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String output = "Hello from: " + parameter + " : " + value;

		return Response.status(200).entity(output).build();
	}
	
	@POST 
	@Path("/login")
	public Response userLogin(@FormParam("email") String email, 
			@FormParam("password") String password ) {
			String output = "";
			System.out.println("Username is: "+email);
			DbConnection dbcon = new DbConnection();
			if(dbcon.loginCheck(email, password))
			{
			output = "Login Successful for "+ email;
				
			System.out.println("Controller message: User was successfully validated in db");
			
			}
			return Response.status(200).entity(output).build();

	}

}
