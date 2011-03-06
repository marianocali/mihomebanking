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
<TH>First Name</TH>
<TH>Last Name</TH>
<TH>User Name</TH>
<TH>Password</TH>
</TR>
<%
  String sql = "SELECT COUNTRY_ID, COUNTRY_NAME, REGION_ID " +
  " FROM COUNTRIES ";
  try {
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");

    Statement s = con.createStatement();
    ResultSet rs = s.executeQuery(sql);

    while (rs.next()) {
%>
<TR>
<TD><% out.print(rs.getString(1)); %></TD>
<TD><% out.print(rs.getString(2)); %></TD>
<TD><% out.print(rs.getInt(3)); %></TD>
</TR>
<%
    }
    rs.close();
    s.close();
    con.close();
  }
  catch (SQLException e) {
  }
  catch (Exception e) {
  }
%>
</TABLE>
</CENTER>
</BODY>
</HTML>
