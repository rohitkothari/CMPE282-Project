package com.cmpe282.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cmpe282.rest.domain.User;

public class DbConnection {
	
public boolean loginCheck(String username, String password){
    String query;
    boolean login = false;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection("jdbc:mysql://cmpe282.cezm78dqy1fn.us-west-1.rds.amazonaws.com:3306/cmpe282", "clouduser", "clouduser");
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT username, password FROM user WHERE username='" + username + "' AND password='" + password + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        login = rs.first();
        
        rs.close();
        stmt.close();
        con.close();
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return login;
}

public boolean signup(User user) {
	// TODO Auto-generated method stub
	boolean signup = false;
	String query = "Insert into user"
			+ "(username, password, firstname, lastname, address, pin, mobile) values"
			+ "(?,?,?,?,?,?,?)";
	 
	
    try {
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	//Using AWS RDS instance of Rohit
    	Connection con = DriverManager.getConnection("");
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, user.getUsername());
    	ps.setString(2, user.getPasswd());
    	ps.setString(3, user.getFirstName());
    	ps.setString(4, user.getLastName());
    	ps.setString(5, user.getAddress());
    	ps.setInt(6, user.getPin());
    	ps.setInt(7, user.getMobile());
    	
    	ps.executeUpdate();
    	signup = true;
    	System.out.println("User successfully inserted into db");
    	
        ps.close();
        con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    //Statement stmt = (Statement) con.createStatement();
    
	
	return signup;
}

public User showUserProfile(String username){
    String query;
    User user = new User();

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection("");
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM user WHERE username='" + username + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            //Retrieve by column name
        	user.setUsername(username);
        	user.setFirstName(rs.getString("firstname"));
        	user.setLastName(rs.getString("lastname"));
        	user.setAddress(rs.getString("address"));
        	user.setPin(rs.getInt("pin"));
        	user.setMobile(rs.getInt("mobile"));           
         }
        
        rs.close();
        stmt.close();
        con.close();
        
        
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}
}