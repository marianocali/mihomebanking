<%! 
  String getSystemTime() {
    return Calendar.getInstance().getTime().toString();
  }
%>
<%@ page import="java.util.Calendar" %> 
<%@ page session="false" %>
<%
  	out.println("Current Time: " + getSystemTime());
	out.println("i= " + ++i);
%>
<%! int i; %>
