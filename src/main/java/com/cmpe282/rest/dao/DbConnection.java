package com.cmpe282.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cmpe282.rest.domain.Question;
import com.cmpe282.rest.domain.Reco;
import com.cmpe282.rest.domain.User;
import com.cmpe282.rest.domain.UserAnswer;



public class DbConnection {
	
	private static final String connectionString = "jdbc:mysql://cmpe282.cezm78dqy1fn.us-west-1.rds.amazonaws.com:3306/cmpe282";
	private static final String cred = "clouduser";
	
	public boolean loginCheck(String username, String password){
    String query;
    boolean login = false;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
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
    	Connection con = DriverManager.getConnection(connectionString,cred,cred);
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
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
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

public boolean recordUserAnswers(UserAnswer answers) {
	// TODO Auto-generated method stub
	boolean recorded = false;
	String query = "Insert into survey"
			+ "(username, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10) values"
			+ "(?,?,?,?,?,?,?,?,?,?,?)";
	 System.out.println("DAO - answer1: "+answers.getAnswer1());
	 System.out.println("DAO - answer2: "+answers.getAnswer2());
    try {
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	//Using AWS RDS instance of Rohit
    	Connection con = DriverManager.getConnection(connectionString,cred,cred);
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, answers.getUser());
    	ps.setString(2, answers.getAnswer1());
    	ps.setString(3, answers.getAnswer2());
    	ps.setString(4, answers.getAnswer3());
    	ps.setString(5, answers.getAnswer4());
    	ps.setString(6, answers.getAnswer5());
    	ps.setString(7, answers.getAnswer6());
    	ps.setString(8, answers.getAnswer7());
    	ps.setString(9, answers.getAnswer8());
    	ps.setString(10, answers.getAnswer9());
    	ps.setString(11, answers.getAnswer10());
    	
    	
    	ps.executeUpdate();
    	recorded = true;
    	System.out.println("User answers recorded successfully");
    	
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
    
	
	return recorded;
}
public Reco showReco(String username){
    String query;
    Reco reco = new Reco();

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM recoone WHERE user='" + username + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            //Retrieve by column name
        	reco.setReco(rs.getString("reco"));          
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
    return reco;
}

public List<Question> showQuestions(){
    String query;
    Question question = new Question();
    List<Question> questions = new ArrayList<Question>();
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM questions";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            //Retrieve by column name
        	question.setQuestionsId(rs.getInt("questionsid"));
        	System.out.println(rs.getInt("questionsid"));
        	question.setQuestion(rs.getString("question"));
        	System.out.println(rs.getString("question"));
        	question.setOption1(rs.getString("option1"));
        	//System.out.println();
        	question.setOption2(rs.getString("option2"));
        	//System.out.println();
        	question.setOption3(rs.getString("option3"));
        	//System.out.println();
        	question.setOption4(rs.getString("option4"));
//        	System.out.println();
        	
        	questions.add(question);
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
    return questions;
}
}