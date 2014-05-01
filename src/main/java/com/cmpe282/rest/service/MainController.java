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
import com.cmpe282.rest.domain.User;
//HelloWorldREST.java

@Path("/MainController")
public class MainController {

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
			return Response.status(200).entity(output).build();
			}
			else{
				return Response.status(400).entity(output).build();	
			}
	}
	
	@POST 
	@Path("/signup")
	public Response signup(@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName, 
			@FormParam("email") String username,
			@FormParam("password") String password,
			@FormParam("address") String address,
			@FormParam("pin") int pin,
			@FormParam("mobile") int mobile) {
			String output = "";
			System.out.println("Username is: "+username);
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setAddress(address);
			user.setPasswd(password);
			user.setMobile(mobile);
			user.setPin(pin);
			
			DbConnection dbcon = new DbConnection();
			boolean res = dbcon.signup(user);
			if(res)
			{
			output = "User " + username + " added successfully to system";
				
			System.out.println("Controller message: User was successfully added to db");
			
			}
			return Response.status(200).entity(output).build();

	}
	
	@GET 
	@Path("/user/profile")
	public Response showUserProfile(@FormParam("email") String email) {
			String output = "";
			System.out.println("Username is: "+email);
			DbConnection dbcon = new DbConnection();
			User user = dbcon.showUserProfile(email);
			if(user!=null)
			{
				output = "Showing profile for user "+ email;
				
				System.out.println("Controller message: User's profile was successfully shown");
				return Response.status(200).entity(output).build();
			}
			else{
				return Response.status(400).entity(output).build();	
			}
	}

}
