package com.cmpe282.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import com.cmpe282.rest.dao.Config;
import com.cmpe282.rest.dao.DbConnection;
import com.cmpe282.rest.domain.Reco;
import com.cmpe282.rest.domain.Recos;
import com.cmpe282.rest.domain.Recot;
import com.cmpe282.rest.domain.Recou;
import com.cmpe282.rest.domain.User;
import com.cmpe282.rest.domain.UserAnswer;
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
				
				User user = dbcon.showUserProfile(email);
				session.setAttribute("firstname", user.getFirstName());
				session.setAttribute("lastname", user.getLastName());
				session.setAttribute("address", user.getAddress());
				session.setAttribute("pin", user.getPin());
				session.setAttribute("mobile", user.getMobile());
				
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
			session.setAttribute("firstname", user.getFirstName());
			session.setAttribute("lastname", user.getLastName());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("pin", user.getPin());
			session.setAttribute("mobile", user.getMobile());
			System.out.println("Controller message: User was successfully added to db");
			
			}
			return Response.status(200).entity(output).build();

	}
	
		@GET
		@Path("profile")
		
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
	       
	        Reco reco = dbcon.showReco(username);
	        System.out.println("Inside Controller - user/reco trial");
	        map.put("reco", reco.getReco());
	        
	        l.add(user.getUsername());
	        l.add(user.getFirstName());
	        l.add(user.getLastName());
	        l.add(user.getAddress());
	        //l.add(user.getPin());
	        map.put("items", l);
	        
	        return Response.ok(new Viewable("/jsp/NewProfile", map)).build();	        
	    }
		@GET
		@Path("/user/reco")
		 public Response showReco(@Context HttpServletRequest req) {
				HttpSession session= req.getSession(false);
				 String username = (String) session.getAttribute("username");
			        DbConnection dbcon = new DbConnection();
			        Reco reco = dbcon.showReco(username);
					
				System.out.println("Checking username got from session- " +username);
				Map<String, Object> map = new HashMap<String, Object>();
		        System.out.println("Inside Controller - user/reco trial");
		        
		        map.put("reco", reco.getReco());
		        		       		        
		        return Response.ok(new Viewable("/jsp/NewProfile", map)).build();	        
		    }
		   
		@POST 
		@Path("/reco")
		public Response recordUserAnswers(@FormParam("s") String s,
				@Context HttpServletRequest req){ 
				HttpSession session= req.getSession(false);
				String user = (String) session.getAttribute("username");
				UserAnswer answers = new UserAnswer();
				answers.setUser(user);
				String output = "";
				//System.out.println("Inside Controller - Posting user's answers - county: "+county);
				System.out.println("s: "+ s);
				s = s.replace("zzz", "$");
				
				s = s.replace("yyy","-");
				s = s.replace("qqq","/");
				s = s.replace("ppp","%");
				System.out.println("new s: "+ s);
				
				String[] parts = s.split(",");
				for(int i=0;i<10;i++){
					System.out.println("part " +i+ " - " +parts[i]);	
				}
				answers.setAnswer1(parts[0]); // age range 1­14 15­24 25­44 45­64 65+
				answers.setAnswer2(parts[1]); // White Black Hispanic Other
				answers.setAnswer3(parts[2]); // county 
				answers.setAnswer4(parts[3]); // Income Less than $ 30k/annum Between $30k/annum ­ $50k/annum Between $50k/annum ­ $80k/annum More than $ 80k/annum 
				answers.setAnswer5(parts[4]); // Weight Less than 60 kg Between 60kg ­ 80kg Between 80kg ­ 100kg More than 100kg 
				answers.setAnswer6(parts[5]); // passed high school diploma yes no 
				answers.setAnswer7(parts[6]); // Exersice // All 7 days Between 4 ­ 6 days Between 2 ­ 4 days  Never 
				answers.setAnswer8(parts[7]);  // hhealthy food  // Between 75 % ­ 100 % Between 50 % ­ 75%  Between 25% ­ 50% Less than 25%
				answers.setAnswer9(parts[8]); //Smoking Between 75 % ­ 100 % Between 50 % ­ 75% Between 25% ­ 50% Less than 25%
				answers.setAnswer10(parts[9]); 	// Health Insurance Yes nO
				System.out.println("Controller - Answer1 from object: "+answers.getAnswer1());
				
				DbConnection dbcon = new DbConnection();
				boolean res = dbcon.recordUserAnswers(answers);
				Recos recos = dbcon.showRecos(answers);
				System.out.println("recos fruits" + recos.getFruits());
				Recot recot = dbcon.showRecot(answers);
				System.out.println("recot popl density" + recot.getPopulation_Density());
				Recou recou = dbcon.showRecou(answers);
				System.out.println("recou unhealthy days" + recou.getUnhealthy_Days());
				String exerciseReco = "", weightReco ="", foodReco="", smokingReco="", toxicReco="", cancerReco="";
				
				if (recou.getB_BI_Cancer() > 30 ||  recou.getB_Hi_Cancer() > 30 ||
						recou.getB_Ot_Cancer() > 30 ||	recou.getB_Wh_Cancer() > 30 ||
						recou.getC_BI_Cancer() > 30 ||	recou.getC_Hi_Cancer() > 30 ||
						recou.getC_Ot_Cancer() > 30 ||  recou.getC_Wh_Cancer() > 30 ||
						recou.getD_BI_Cancer() > 30 ||	recou.getD_Hi_Cancer() > 30 ||
						recou.getD_Ot_Cancer() > 30 ||  recou.getD_Wh_Cancer() > 30 ||
						recou.getE_BI_Cancer() > 30 || recou.getE_Hi_Cancer() > 30 ||
						recou.getE_Ot_Cancer() > 30 ||  recou.getE_Wh_Cancer() > 30 )
				cancerReco = "People of your age range are at high risk of cancer!!";
				session.setAttribute("cancerReco", cancerReco);

				
				if (parts[7].equals("Less than 25%"))
					foodReco = "Please consider having healthy food!! Good for you!!";
				else
					foodReco = "You seems to be good with diet!! Be consistent!!";
				session.setAttribute("foodReco", foodReco);
				
				if (parts[4].equals("More than 100kg"))
					weightReco = "Please consider doing exerice more often!! Your weight might create you a problem!!";
				else
					weightReco = "You seems to be fit!! Be consistent!!";
				session.setAttribute("weightReco", weightReco);
				
				if (parts[6].equals("never"))
					exerciseReco = "Please consider doing exerice more often!! Good for you!!";
				else
					exerciseReco = "You are doing great with exercise!! Be consistent!!";
				session.setAttribute("exerciseReco", exerciseReco);
				
				if (parts[8].equals("Between 75 % ­ 100 %"))
					smokingReco = "You might be at high risk of Lung Cancer!! Please be careful and control smoking!!";
				else
					smokingReco = "Good that you smoke less!! Keep it up!!";
				session.setAttribute("smokingReco", smokingReco);
				
				if(recot.getToxic_Chem() > 20000)
					toxicReco = "You may be prone to toxic chemicals in your surrounding!!";
				else
					toxicReco = "You live in healthy air!!";
				session.setAttribute("toxicReco", toxicReco);
				
				/*ArrayList<String> quotes = Config.getListOfQuotes();
		        Random randomGenerator =  new Random();
		        int index = randomGenerator.nextInt(quotes.size());
		        String quote1 = quotes.get(index);
		        session.setAttribute("quote1", quote1);
		        index = randomGenerator.nextInt(quotes.size());
		        String quote2 = quotes.get(index);
		        session.setAttribute("quote2", quote2);
		        index = randomGenerator.nextInt(quotes.size());
		        String quote3 = quotes.get(index);
		        session.setAttribute("quote3", quote3);*/
		        
				if(res)
				{
				output = "Answers added successfully to system";
				System.out.println("Controller message: Answers added successfully to system");
				
				}
				 Reco reco = dbcon.showReco(user);
				session.setAttribute("reco1", reco.getReco());
				
				return Response.status(200).entity(output).build();

		}
		
		
		@GET
		@Path("/logout")
		public Response logout(@Context HttpServletRequest req) {
			HttpSession session= req.getSession(false);
			System.out.println("Inside Controller - testing logout functionality");
			session.invalidate();
			return Response.ok(new Viewable("/jsp/index")).build();
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
