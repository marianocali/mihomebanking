package com.mybank.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Content2Servlet extends HttpServlet {

	public String loginUrl = "SessionLoginServlet";

	/** Process the HTTP Get request */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session == null)
			response.sendRedirect(loginUrl);
		else {
			String loggedIn = (String) session.getAttribute("loggedIn");
			if (!loggedIn.equals("true"))
				response.sendRedirect(loginUrl);
		}
		// This is an authorized user, okay to display content
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Welcome</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Welcome. " + session.getAttribute("loggedIn") + " "
								+ session.getAttribute("ID"));
		out.println(mostrarDatosCliente((String) session.getAttribute("ID")));
		out.println("</BODY>");
		out.println("</HTML>");
	}

	/** Process the HTTP Post request */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public static StringBuffer mostrarDatosCliente(String id) {
		StringBuffer datosCliente = new StringBuffer("");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			Statement s = con.createStatement();
			String sql = "SELECT * FROM CLIENTES" + " WHERE ID='" + id + "'";
			// StringUtil.fixSqlFieldValue(userName)
			// StringUtil.fixSqlFieldValue(password)

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				datosCliente = datosCliente.append(rs.getString(1) + " "
						+ rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5) + " "
						+ rs.getString(6) + " " + rs.getString(7) + " "
						+ rs.getString(8) + " " + rs.getString(9) + "\n");
				rs.close();
				s.close();
				con.close();
				return datosCliente;
			}
			rs.close();
			s.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return datosCliente;
	}
}
