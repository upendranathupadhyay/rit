package com.result;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Utility;

public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con = null;
		PreparedStatement pst;
		Statement st;
		ResultSet rs;
		PrintWriter pw =  response.getWriter();
		String str = request.getParameter("id");
		if("All".equals(str))
		{
			pw.println("<html><body bgcolor='BurlyWood'><center>");
			/*String nextJSP = "/index.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);*/
			try{
				
				con = Utility.gettingConnection();
				st=con.createStatement();
				rs=st.executeQuery("select * from emp");
				
				ResultSetMetaData rsmd = rs.getMetaData();
				pw.print("<table border='1'><tr><td>");
				pw.print(rsmd.getColumnName(1)+"</td><td>"+rsmd.getColumnName(2)+"</td><td>"+rsmd.getColumnName(3));
				pw.print("</td></tr>");
				while(rs.next())
				{
					pw.print("<tr><td>");
					pw.print(rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3));
					pw.print("</td></tr>");
				}
				pw.print("</table>");
				pw.print("</center></body></html>");
			}catch(Exception e)
			{
				pw.print("Connection Failed");
			}
			
		}
		else if("ID".equals(str))
		{
			pw.println("<html><body bgcolor='BurlyWood'><center>");
			int id = 0;
			try{
			 id = Integer.parseInt(request.getParameter("text1"));
			}catch (Exception e) {
				pw.println("ID input is not proper"+"<br>");
			}
			try{
					con = Utility.gettingConnection();
					pst=con.prepareStatement("select * from emp where id=?");
					pst.setInt(1, id);
					rs=pst.executeQuery();
					if(!rs.isBeforeFirst())
					{
						pw.println("No Data Found");
					}
					else
					{	
						ResultSetMetaData rsmd = rs.getMetaData();
						pw.print("<table border='1'><tr><td>");
						pw.print(rsmd.getColumnName(1)+"</td><td>"+rsmd.getColumnName(2)+"</td><td>"+rsmd.getColumnName(3));
						pw.print("</td></tr>");
						while(rs.next())
						{
							pw.print("<tr><td>");
							pw.print(rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3));
							pw.print("</td></tr>");
						}
						pw.print("</table>");
						pw.print("</center></body></html>");
					}
				}
			catch(Exception e)
			{
				pw.println("Error Occurred");
			}
			
		}
		else if("Name".equals(str))
		{
			pw.println("<html><body bgcolor='BurlyWood'><center>");
			String name = request.getParameter("text2");
			try{
				con = Utility.gettingConnection();
				pst=con.prepareStatement("select * from emp where name LIKE '%"+name+"%'");
				rs=pst.executeQuery();
				if(!rs.isBeforeFirst())
				{
					pw.println("No Data Found");
				}
				else
				{	
					ResultSetMetaData rsmd = rs.getMetaData();
					pw.print("<table border='1'><tr><td>");
					pw.print(rsmd.getColumnName(1)+"</td><td>"+rsmd.getColumnName(2)+"</td><td>"+rsmd.getColumnName(3));
					pw.print("</td></tr>");
					while(rs.next())
					{
						pw.print("<tr><td>");
						pw.print(rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3));
						pw.print("</td></tr>");
					}
					pw.print("</table>");
					pw.print("</center></body></html>");
				}
			}catch(Exception e)
			{
				pw.println("Error Occurred");
			}
		}
		else
		{
			pw.println("<html><body bgcolor='BurlyWood'><center>");
			int id = 0;
			try{
			 id = Integer.parseInt(request.getParameter("text1"));
			}catch(NumberFormatException e)
			{
				pw.println("No ID is given"+"<br>");
			}catch (Exception e) {
				pw.println("ID input is not proper");
			}
			String name = request.getParameter("text2");
			try{
				con = Utility.gettingConnection();
				pst=con.prepareStatement("select * from emp where id=? and name=?");
				pst.setInt(1, id);
				pst.setString(2, name);
				rs=pst.executeQuery();
				if(!rs.isBeforeFirst())
				{
					pw.println("No Data Found");
				}
				else
				{	
					ResultSetMetaData rsmd = rs.getMetaData();
					pw.print("<table border='1'><tr><td>");
					pw.print(rsmd.getColumnName(1)+"</td><td>"+rsmd.getColumnName(2)+"</td><td>"+rsmd.getColumnName(3));
					pw.print("</td></tr>");
					while(rs.next())
					{
						pw.print("<tr><td>");
						pw.print(rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3));
						pw.print("</td></tr>");
					}
					pw.print("</table>");
					pw.print("</center></body></html>");
				}
			}catch(Exception e)
			{
				pw.println("Error Occurred");
			}
		}
		
		
	}

}
