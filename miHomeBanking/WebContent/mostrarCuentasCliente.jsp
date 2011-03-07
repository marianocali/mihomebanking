<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>
<%
	HttpSession session = request.getSession();
	if (session == null) {
		System.out.println("es null");
		response.sendRedirect("login");
	} else {
		String loggedIn = (String) session.getAttribute("loggedIn");
		if (!loggedIn.equals("true"))
			response.sendRedirect("login");
	}

	String id = (String) session.getAttribute("ID");
	Cliente elCliente = new Cliente(id);
	CajaDeAhorro cajaDeAhorro = null;
	CuentaCorriente cuentaCorriente = null;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC driver loaded");
	} catch (ClassNotFoundException e) {
		System.out.println(e.toString());
	}
%>
<HTML>
<HEAD>
<TITLE>Bienvenido a la Página de sus Cuentas</TITLE>
</HEAD>
<BODY>
<CENTER><BR>
<H2>Sus Cuentas</H2>
<H2>Sus Cuentas</H2>
<BR>
<BR>
<TABLE>
	<TR>
		<TH>Numero de Cuenta</TH>
		<TH>Tipo de Cuenta</TH>
		<TH>Saldo</TH>
	</TR>
	<%
		String sql = "SELECT * FROM CLIENTES WHERE ID = '" + id + "'";

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				elCliente.setApellido(rs.getString(2));
				elCliente.setNombre(rs.getString(3));
				elCliente.setDocumento(rs.getString(4));
				elCliente.setCajaDeAhorro(rs.getString(5));
				elCliente.setCuentaCorriente(rs.getString(6));
				System.out.println(elCliente);
//				out.println("<TR>");
//				out.println("<TD>" + rs.getString(1) + "</TD>");
//				out.println("<TD>" + rs.getString(2) + "</TD>");
				//				out.println("<TD>" + rs.getInt(3) + "</TD>");

//				out.println("</TR>");
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
		} catch (Exception e) {
		}
	%>
</TABLE>
</CENTER>
</BODY>
</HTML>