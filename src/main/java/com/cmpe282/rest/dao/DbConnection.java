package com.cmpe282.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.cmpe282.rest.domain.Question;
import com.cmpe282.rest.domain.Reco;
import com.cmpe282.rest.domain.Recos;
import com.cmpe282.rest.domain.Recot;
import com.cmpe282.rest.domain.Recou;
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
        //Config.setHm(null);
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
	//Config.setHm(null);
	
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

public Recos showRecos(UserAnswer answers){
    String query;
    Recos recos = new Recos();
    String userCounty = answers.getAnswer3();
    System.out.println("User selected this county-->"+userCounty);
    //Do here -->Look up into our county hashmap to find out county's ID
    
    System.out.println("hashmap size-->"+Config.getHm().size());
    int countyId = Config.getHm().get(userCounty);
    System.out.println("countyID fetched from hashmap-->"+countyId);
    //int countyId = 1;
      
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM recos WHERE county_FIPS_code='" + countyId + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            //Retrieve by column name
        	recos.setAgeUnder19(rs.getFloat("Age_19_Under"));
        	System.out.println("Age under 19 - from recos db: " +rs.getFloat("Age_19_Under"));
        	recos.setAge1964(rs.getFloat("Age_19_64"));
        	recos.setAge6584(rs.getFloat("Age_65_84"));
        	recos.setBlack(rs.getFloat("Black"));
        	recos.setWhite(rs.getFloat("White"));
        	recos.setOther(rs.getFloat("Other"));
        	recos.setHispanic(rs.getFloat("Hispanic"));
        	recos.setNoHSDiploma(rs.getInt("No_HS_Diploma"));
        	recos.setUnemployed(rs.getInt("Unemployed"));
        	recos.setNoExercise(rs.getFloat("No_Exercise"));
        	recos.setFruits(rs.getFloat("Fruits"));
        	recos.setSmoker(rs.getFloat("Smoker"));
        	recos.setUninsured(rs.getInt("Uninsured"));
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
    return recos;
}

public Recot showRecot(UserAnswer answers){
    String query;
    Recot recot = new Recot();
    String userCounty = answers.getAnswer3();
    System.out.println("User selected this county-->"+userCounty);
    //Do here -->Look up into our county hashmap to find out county's ID
    
    System.out.println("hashmap size-->"+Config.getHm().size());
    int countyId = Config.getHm().get(userCounty);
    System.out.println("countyID fetched from hashmap-->"+countyId);
    //int countyId = 1;
      
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM recot WHERE county_FIPS_code='" + countyId + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
       
        while(rs.next()){
        	recot.setPopulation_Density(rs.getFloat("Population_Density"));
        	recot.setPoverty(rs.getFloat("Poverty"));
        	recot.setEcol_Rpt(rs.getFloat("Ecol_Rpt"));
        	recot.setEcol_Rpt_Ind(rs.getFloat("Ecol_Rpt_Ind"));
        	recot.setEcol_Exp(rs.getFloat("Ecol_Exp"));
        	recot.setSalm_Rpt(rs.getFloat("Salm_Rpt"));
        	recot.setShig_Rpt(rs.getFloat("Shig_Rpt"));
        	recot.setShig_Rpt_Ind(rs.getInt("Shig_Rpt_Ind"));
        	recot.setSalm_Rpt_Ind(rs.getInt("Salm_Rpt_Ind"));
        	recot.setToxic_Chem(rs.getFloat("Toxic_Chem"));
        	recot.setCarbon_Monoxoide_Ind(rs.getFloat("Carbon_Monoxide_Ind"));
        	recot.setNitrogen_Dioxide_Ind(rs.getFloat("Nitrogen_Dioxide_Ind"));
        	recot.setSulfur_Dioxide_Ind(rs.getInt("Sulfur_Dioxide_Ind"));
        	recot.setOzone_Ind(rs.getInt("Ozone_Ind"));
        	recot.setParticulate_Matter_Ind(rs.getInt("Particulate_Matter_Ind"));
        	recot.setLead_Ind(rs.getInt("Lead_Ind"));
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
    return recot;
}

public Recou showRecou(UserAnswer answers){
    String query;
    Recou recou = new Recou();
    String userCounty = answers.getAnswer3();
    System.out.println("User selected this county-->"+userCounty);
    //Do here -->Look up into our county hashmap to find out county's ID
    
    System.out.println("hashmap size-->"+Config.getHm().size());
    int countyId = Config.getHm().get(userCounty);
    System.out.println("countyID fetched from hashmap-->"+countyId);
    //int countyId = 1;
                   
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        //Using AWS RDS instance of Rohit
        Connection con = DriverManager.getConnection(connectionString,cred,cred);
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT * FROM recou WHERE county_FIPS_code='" + countyId + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        while(rs.next()){
            //Retrieve by column name
        	recou.setB_Wh_Cancer(rs.getFloat("B_Wh_Cancer"));
        	recou.setUS_Unhealthy_Days(rs.getFloat("US_Unhealthy_Days"));
        	recou.setUnhealthy_Days(rs.getFloat("Unhealthy_Days"));
        	recou.setUS_Health_Status(rs.getFloat("US_Health_Status"));
        	recou.setHealth_Status(rs.getFloat("Health_Status"));
        	recou.setUS_All_Death(rs.getFloat("US_All_Death"));
        	recou.setAll_Death(rs.getFloat("All_Death"));
        	recou.setUS_ALE(rs.getInt("US_ALE"));
        	recou.setF_Hi_Cancer(rs.getInt("F_Hi_Cancer"));
        	recou.setALE(rs.getFloat("ALE"));
        	recou.setF_Hi_Cancer(rs.getFloat("F_Hi_Cancer"));
        	recou.setF_Ot_Cancer(rs.getFloat("F_Ot_Cancer"));
        	recou.setF_BI_Cancer(rs.getInt("F_Bl_Cancer"));
        	recou.setF_Wh_Cancer(rs.getInt("F_Wh_Cancer"));
        	
        	recou.setE_Hi_Cancer(rs.getInt("E_Hi_Cancer"));
        	recou.setE_BI_Cancer(rs.getInt("E_Bl_Cancer"));
        	recou.setE_Ot_Cancer(rs.getInt("E_Ot_Cancer"));
        	recou.setE_Wh_Cancer(rs.getInt("E_Wh_Cancer"));
        	
        	recou.setD_Hi_Cancer(rs.getInt("D_Hi_Cancer"));
        	recou.setD_BI_Cancer(rs.getInt("D_Bl_Cancer"));
        	recou.setD_Ot_Cancer(rs.getInt("D_Ot_Cancer"));
        	recou.setD_Wh_Cancer(rs.getInt("D_Wh_Cancer"));
        	
        	recou.setC_Hi_Cancer(rs.getInt("C_Hi_Cancer"));
        	recou.setC_BI_Cancer(rs.getInt("C_Bl_Cancer"));
        	recou.setC_Ot_Cancer(rs.getInt("C_Ot_Cancer"));
        	recou.setC_Wh_Cancer(rs.getInt("C_Wh_Cancer"));
        	
        	recou.setB_Hi_Cancer(rs.getInt("B_Hi_Cancer"));
        	recou.setB_BI_Cancer(rs.getInt("B_Bl_Cancer"));
        	recou.setB_Ot_Cancer(rs.getInt("B_Ot_Cancer"));
        	recou.setB_Wh_Cancer(rs.getInt("B_Wh_Cancer"));
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
    return recou;
}


//Do not use this function - instead see showRecos() above
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