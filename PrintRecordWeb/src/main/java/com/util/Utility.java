package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Utility {

	public static Connection gettingConnection()  throws Exception
	{
		Connection con;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		return con;
	}
	
	public static boolean isInteger(String s) throws Exception {
	   
		
		try
	      {
	         Object a= Integer.parseInt(s);
	         if(a.getClass() == Integer.class)
	         {
	         return true;
	         }
	      }
	      catch (NumberFormatException ex)
	      {
	    	  return false;
	      }
	 
		return false;
		
		}
}
