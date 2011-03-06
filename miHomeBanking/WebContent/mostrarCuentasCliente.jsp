<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>
<%
	String id = "1";
	Cliente elCliente = new Cliente(id);  
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
<BR>
<BR>
<TABLE>
	<TR>
		<TH>Numero de Cuenta</TH>
		<TH>Tipo de Cuenta</TH>
		<TH>Saldo</TH>
	</TR>
	<%
		String sql = "SELECT CAJA_DE_AHORRO, CUENTA_CORRIENTE "
				+ " FROM CLIENTES WHERE ID = '" + id + "'";

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				out.println("<TR>");
				out.println("<TD>" + rs.getString(1) + "</TD>");
				out.println("<TD>" + rs.getString(2) + "</TD>");
				//				out.println("<TD>" + rs.getInt(3) + "</TD>");

				out.println("</TR>");
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