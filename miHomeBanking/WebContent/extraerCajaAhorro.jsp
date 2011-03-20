<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>
<%
	HttpSession session = request.getSession();
	if (session == null) {
		System.out.println("session es null, no esta creada la sesion");
		response.sendRedirect("Login");
	} else {
		String loggedIn = (String) session.getAttribute("loggedIn");
		System.out.println("logeddIn :" + loggedIn);
		if (!loggedIn.equals("true")) {
			response.sendRedirect("Login");
		}
	}

	String id = (String) session.getAttribute("ID");
	Cliente elCliente = new Cliente(id);
	elCliente.cargarCliente(Integer.parseInt(id)); //carga el cliente con sus cuentas
	//System.out.println(elCliente);
%>

<HTML>
<HEAD>
<TITLE>Extracci&oacute;n Caja de Ahorro</TITLE>
</HEAD>
<BODY>
<CENTER><BR>
<BR>
<BR>

<h2>Extracci&oacute;n en Caja de Ahorro de <%
	out.println("<TD>" + elCliente.getApellido() + "</TD>");
	out.println("<TD>" + elCliente.getNombre() + "</TD>");
%>
</h2>
<FORM METHOD=POST ACTION=mostrarResultadoExtraccion.jsp>

<TABLE border=1>
	<TR>
		<TH>
		<h3>su saldo actual</h3>
		</TH>
		<TH>
		<h3>Ingrese el monto a retirar</h3>
		</TH>
	</TR>
	<TR>
		<%
			out.println("<TD>" + elCliente.getCajaDeAhorro().getSaldo()
					+ "</TD>");
		%>
		<td><input type="text" name=montoIngresado></td>
	</TR>
	<TR>
		<Td></Td>
		<Td><INPUT TYPE=SUBMIT> 

		<input align="RIGHT" type="button" value="Cancelar"
			onclick="location.href = 'mostrarCuentasCliente.jsp'";
></Td>

	</TR>

</TABLE>
</FORM>

</CENTER>

</body>
</html>