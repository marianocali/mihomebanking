
<jsp:useBean id="validaLogin" class="com.mybank.domain.ValidaLoginBean" /><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<HTML>
<HEAD>
<TITLE>Login</TITLE>
</HEAD>
<BODY>
<CENTER>
<%
	if ("false".equals(session.getAttribute("loggedIn").toString())
			&& request.getParameter("userName")==null
			&& request.getParameter("password")==null) {
	} else {
		out.println("Login failed. Please try again.<BR>");
		out
				.println("If you think you have entered the correct user name"
						+ " and password, the cookie setting in your browser might be off."
						+ "<BR>Click <A HREF=InfoPage.html>here</A> for information"
						+ " on how to turn it on.<BR>");
	}
%> <BR>
<BR>
<H2>Login Page</H2>
<BR>
<BR>
Please enter your user name and password. <BR>
<BR>
<FORM METHOD=POST action=login>
<TABLE>

	<TR>
		<TD>User Name:</TD>
		<TD><INPUT TYPE=TEXT NAME=userName></TD>
	</TR>
	<TR>
		<TD>Password:</TD>
		<TD><INPUT TYPE=PASSWORD NAME=password></TD>
	</TR>
	<TR>
		<TD ALIGN=RIGHT COLSPAN=2><INPUT TYPE=SUBMIT VALUE=login></TD>
	</TR>
</TABLE>
</FORM>
</CENTER>
</BODY>
</HTML>