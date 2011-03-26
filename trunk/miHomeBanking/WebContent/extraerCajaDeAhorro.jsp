<jsp:useBean id="cliente" class="com.mybank.domain.ClienteBean"/>
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
	cliente.cargarCliente(Integer.parseInt(id)); //carga el cliente con sus cuentas
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
	out.println("<TD>" + cliente.getApellido() + "</TD>");
	out.println("<TD>" + cliente.getNombre() + "</TD>");
%>
</h2>
<FORM METHOD="POST" ACTION="http://localhost:8081/miHomeBanking/mostrarResultadoExtraccionCajaDeAhorro?action=mostrarResultadoExtraccionCajaDeAhorro">


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
			out.println("<TD>" + cliente.getCajaDeAhorro().getSaldo()
					+ "</TD>");
		%>
		<td><input type="text" name=montoIngresado></td>
	</TR>
	<TR>
		<Td colspan = 2 align="center"> 
			<INPUT TYPE=SUBMIT> 
			<input type="button" value="Cancelar"
			onclick="location.href = 'mostrarCuentasCliente.jsp'";
		></Td>

	</TR>

</TABLE>
</FORM>

</CENTER>

</body>
</html>