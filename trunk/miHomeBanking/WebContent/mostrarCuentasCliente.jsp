<jsp:useBean id="cliente" class="com.mybank.domain.ClienteBean"/>
<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>

<%
	HttpSession session = request.getSession();
	if (session == null) {
		System.out.println("session es null, no esta creada la sesion");
		response.sendRedirect("login");
	} else {
		String loggedIn = (String) session.getAttribute("loggedIn");
		if (!loggedIn.equals("true"))
			response.sendRedirect("login");
	}

	String id = (String) session.getAttribute("ID");
	cliente.cargarCliente(Integer.parseInt(id));
%>
<HTML>
<HEAD>
<TITLE>Bienvenido a la Página de sus Cuentas</TITLE>
</HEAD>
<BODY>
<CENTER><BR>
<BR>
<BR>

<%%>

<h2>Bienvenido <%
	out.println("<TD>" + cliente.getApellido() + "</TD>");
	out.println("<TD>" + cliente.getNombre() + "</TD>");
%>
</h2>
<h3>Estas son sus cuentas:</h3>

<TABLE border=1>
	<TR>
		<TH>Tipo de Cuenta</TH>
		<TH>Saldo</TH>
		<TH>Operación</TH>
	</TR>
	<TR>
		<Td>Caja de Ahorro</Td>

		<%
			if (cliente.getCajaDeAhorro() != null) {
				out.println("<TD>" + cliente.getCajaDeAhorro().getSaldo()
						+ "</TD>");
			}
		%>
		<%
		// out.println("<TD>" + cajaDeAhorro.getSaldo() + "</TD>");
		%>
		<Td><A href="http://localhost:8081/mihomebanking/depositarCajaDeAhorro?action=depositarCajaDeAhorro"> Depositar </A> 
		/ 	<A href="http://localhost:8081/mihomebanking/extraerCajaDeAhorro?action=extraerCajaDeAhorro"> Extraer </A></Td>
	</TR>
	<TR>
		<Td>Cuenta Corriente</Td>

		<%
			if (cliente.getCuentaCorriente() != null) {
				out.println("<TD>" + cliente.getCuentaCorriente().getSaldo()
						+ "</TD>");
			}
		%>
		<%
			// out.println("<TD>" + cajaDeAhorro.getSaldo() + "</TD>");
		%>
		<Td><A href="http://localhost:8081/mihomebanking/depositarCuentaCorriente?action=depositarCuentaCorriente"> Depositar </A> 
		/ 	<A href="http://localhost:8081/mihomebanking/extraerCuentaCorriente?action=extraerCuentaCorriente"> Extraer </A></Td>
	</TR>
</TABLE>
</CENTER>


</BODY>
</HTML>