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
	//System.out.println(elCliente);
%>

<HTML>
<HEAD>
<TITLE>Deposito Cuenta Corriente</TITLE>
</HEAD>
<BODY>
<CENTER><BR>
<BR>
<BR>

<h2>Deposito en Cuenta Corriente de <%
	out.println("<TD>" + cliente.getApellido() + "</TD>");
	out.println("<TD>" + cliente.getNombre() + "</TD>");
%>
</h2>
<FORM METHOD="POST" ACTION="http://localhost:8081/mihomebanking/mostrarResultadoDepositoCuentaCorriente?action=mostrarResultadoDepositoCuentaCorriente">


<TABLE border=1>
	<TR>
		<TH>
		<h3>su saldo actual</h3>
		</TH>
		<TH>
		<h3>sobregiro </h3>
		</TH>
		
		<TH>
		<h3>Ingrese el monto a depositar</h3>
		</TH>
	</TR>
	<TR>
		<%
			out.println("<TD>" + cliente.getCuentaCorriente().getSaldo()
					+ "</TD>");
		
			out.println("<TD>" + cliente.getCuentaCorriente().getSobregiro()
				+ "</TD>");
		
		%>
		<td><input type="text" name=montoIngresado></td>
	</TR>
	<TR>
		<Td colspan=3 align="center"><INPUT TYPE=SUBMIT> 
		<input type="button" value="Cancelar"
			onclick="location.href = 'mostrarCuentasCliente.jsp'";
></Td>

	</TR>

</TABLE>
</FORM>

</CENTER>

</body>
</html>