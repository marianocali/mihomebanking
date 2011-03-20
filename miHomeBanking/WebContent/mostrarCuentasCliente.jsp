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
	Cliente elCliente = new Cliente(id);
	elCliente.cargarCliente(Integer.parseInt(id));
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
	out.println("<TD>" + elCliente.getApellido() + "</TD>");
	out.println("<TD>" + elCliente.getNombre() + "</TD>");
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
			if (elCliente.getCajaDeAhorro() != null) {
				out.println("<TD>" + elCliente.getCajaDeAhorro().getSaldo()
						+ "</TD>");
			}
		%>
		<%
			// out.println("<TD>" + cajaDeAhorro.getSaldo() + "</TD>");
		%>
		<Td><A href="depositarCajaAhorro.jsp"> Depositar </A> / <A href="extraerCajaAhorro.jsp"> Extraer </A></Td>
	</TR>
</TABLE>
</CENTER>


</BODY>
</HTML>