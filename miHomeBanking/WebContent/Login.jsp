<%@ page session="false"%>
<HTML>
<HEAD>
<TITLE>Login</TITLE>
</HEAD>
<BODY>
<FORM METHOD="POST" ACTION="ProcessLogin.jsp">
<%
	if (request.getParameter("error") != null) {
%> Login failed. Please try again <BR>
<HR>
<%
	}
%>
<TABLE>
	<TR>
		<TD>User Name</TD>
		<TD><INPUT TYPE=TEXT NAME="userName"></TD>
	</TR>
	<TR>
		<TD>Password</TD>
		<TD><INPUT TYPE=PASSWORD NAME="password"></TD>
	</TR>
	<TR>
		<TD COLSPAN="2"><INPUT TYPE=SUBMIT VALUE="Login"></TD>
	</TR>
</TABLE>
</FORM>
</BODY>
</HTML>