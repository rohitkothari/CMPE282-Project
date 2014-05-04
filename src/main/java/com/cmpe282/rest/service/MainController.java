package com.cmpe282.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




import com.cmpe282.rest.dao.DbConnection;
import com.cmpe282.rest.domain.User;
import com.sun.jersey.api.view.Viewable;
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
			@FormParam("password") String password,
			@Context HttpServletRequest req) {
			String output = "";
			System.out.println("Username is: "+email);
			DbConnection dbcon = new DbConnection();
			if(dbcon.loginCheck(email, password))
			{
				HttpSession session= req.getSession(true);
				session.setAttribute("username", email);
				session.setAttribute("sessionId", session.getId());
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
			@FormParam("mobile") int mobile,
			@Context HttpServletRequest req) {
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
			
			HttpSession session= req.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("sessionId", session.getId());
			
			System.out.println("Controller message: User was successfully added to db");
			
			}
			return Response.status(200).entity(output).build();

	}
	
		@GET
		@Path("/user/profile")
		
	    public Response showUserProfile(@Context HttpServletRequest req) {
			HttpSession session= req.getSession(false);
			 String username = (String) session.getAttribute("username");
		        DbConnection dbcon = new DbConnection();
				User user = dbcon.showUserProfile(username);
			System.out.println("Checking username got from session- " +username);
			Map<String, Object> map = new HashMap<String, Object>();
	        System.out.println("Inside Controller - user/profile trial");
	        map.put("user", user.getUsername());
	        map.put("firstname", user.getFirstName());
	        map.put("lastname", user.getLastName());
	        map.put("address", user.getAddress());
	        map.put("pin", Integer.toString(user.getPin()));
	        map.put("mobile", Integer.toString(user.getMobile()));
	        List<String> l = new ArrayList<String>();
	       
	        l.add(user.getUsername());
	        l.add(user.getFirstName());
	        l.add(user.getLastName());
	        l.add(user.getAddress());
	        //l.add(user.getPin());
	        map.put("items", l);
	        
	       
			
	        return Response.ok(new Viewable("/jsp/Profile", map)).build();
	        
	        
	    }
	
/*	@GET 
	@Path("/user/profile")
	public Viewable showUserProfile(@FormParam("email") String email, @Context HttpServletRequest request) {
			
		request.setAttribute("obj", new String("IT Works"));
        System.out.println("/INDEX called");
        return new Viewable("/Profile.jsp", null);
		
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
	}*/
	
	
	/*@GET 
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
	}*/

}
