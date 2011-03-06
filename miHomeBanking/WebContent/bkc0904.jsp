<%@ page session="false" %>
<%@ page import="java.sql.*" %>
<%
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    System.out.println("JDBC driver loaded");
  }
  catch (ClassNotFoundException e) {
    System.out.println(e.toString());
  }
%>
<HTML>     
<HEAD>
<TITLE>Display All Countries</TITLE>
</HEAD>
<BODY>
<CENTER>
<BR><H2>Displaying All Countries</H2>
<BR>
<BR>
<TABLE>
<TR>
<TH>Country Id</TH>
<TH>Contry Name</TH>
<TH>Region Id</TH>
</TR>
<%
  String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID " +
    		   " FROM COUNTRIES ";
	
  try {
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
    
    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery(sql);

    while (rs.next()) {
      out.println("<TR>");
      out.println("<TD>" + rs.getString(1) + "</TD>");
      out.println("<TD>" + rs.getString(2) + "</TD>");
      out.println("<TD>" + rs.getInt(3)    + "</TD>");
      
      out.println("</TR>");
    }
    rs.close();
    s.close();
    con.close();
  }
  catch (SQLException e) 
  {
	  //catch
  }
  catch (Exception e) 
  {
  }
%>
</TABLE>
</CENTER>
</BODY>
</HTML>
