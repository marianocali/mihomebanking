package com.mybank.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, 
    HttpServletResponse response)
    throws ServletException, IOException {
    sendLoginForm(response, false);
  }

  private void sendLoginForm(HttpServletResponse response, 
    boolean withErrorMessage)
    throws ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>Login</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<CENTER>");

    if (withErrorMessage)
      out.println("Login failed. Please try again.<BR>");

    out.println("<BR>");
    out.println("<BR><H2>Login Page</H2>");
    out.println("<BR>");
    out.println("<BR>Please enter your user name and password.");
    out.println("<BR>");
    out.println("<BR><FORM METHOD=POST>");
    out.println("<TABLE>");
    out.println("<TR>");
    out.println("<TD>User Name:</TD>");
    out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
    out.println("</TR>");
    out.println("<TR>");
    out.println("<TD>Password:</TD>");
    out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
    out.println("</TR>");
    out.println("<TR>");
    out.println("<TD ALIGN=RIGHT COLSPAN=2>");
    out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
    out.println("</TR>");
    out.println("</TABLE>");
    out.println("</FORM>");
    out.println("</CENTER>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void doPost(HttpServletRequest request, 
    HttpServletResponse response)
    throws ServletException, IOException {
    
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    if (login(userName, password)) 
    {
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      //aca la idea sería llamar a otro servlet que de las opciones que viene luego del logueo
      //
      rd.forward(request, response);
    }
    else 
    {
      sendLoginForm(response, true);
    }
  }

  boolean login(String userName, String password) {
    try {	
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = 
        DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
      System.out.println("got connection");

      Statement s = con.createStatement();
      String sql = 	"SELECT * FROM Clientes" +
			        " WHERE NOMBRECLIENTE ='" + userName + "'" +
			        " AND PASSWORD ='" + password + "'";
      ResultSet rs = s.executeQuery(sql);
      if (rs.next()) 
      {
    	System.out.println(rs);
        rs.close();
        s.close();
        con.close();
        return true;
      }
      rs.close();
      s.close();
      con.close();
    }
    catch (ClassNotFoundException e) {
      System.out.println(e.toString());
    }
    catch (SQLException e) {
      System.out.println(e.toString());
    }
    catch (Exception e) {
      System.out.println(e.toString());
    }
    return false;
  }
}
