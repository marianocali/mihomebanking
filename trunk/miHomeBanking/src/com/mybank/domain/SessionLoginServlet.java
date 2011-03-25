package com.mybank.domain;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionLoginServlet extends HttpServlet 
{
	ValidaLoginBean validador = new ValidaLoginBean(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sendLoginForm(response, false);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (validador.login(userName, password)) 
		{
			// send cookie to the browser
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", new String("true"));
			session.setAttribute("ID", new String(validador.getIdCliente(userName)));
			response.sendRedirect("mostrarCuentasCliente.jsp");
		} 
		else 
		{
			//envía mensaje de error
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", new String("false"));
			response.sendRedirect("login.jsp");
		//	sendLoginForm(response, true);
		}
	}

	private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");

		if (withErrorMessage) {
			out.println("Login failed. Please try again.<BR>");
			out
					.println("If you think you have entered the correct user name"
							+ " and password, the cookie setting in your browser might be off."
							+ "<BR>Click <A HREF=InfoPage.html>here</A> for information"
							+ " on how to turn it on.<BR>");
		}
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
		out.println("<INPUT TYPE=SUBMIT VALUE=login></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</FORM>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
