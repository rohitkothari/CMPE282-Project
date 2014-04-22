package com.cmpe282.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
public boolean loginCheck(String username, String password){
    String query;
    boolean login = false;

    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cmpe282", "root", "password");
        Statement stmt = (Statement) con.createStatement();
        query = "SELECT username, password FROM user WHERE username='" + username + "' AND password='" + password + "';";
        stmt.executeQuery(query);
        ResultSet rs = stmt.getResultSet();
        login = rs.first(); 
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
}