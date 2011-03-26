<jsp:useBean id="cliente" class="com.mybank.domain.ClienteBean"/>
<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>
<%
	HttpSession session = request.getSession();
	if (session == null) 
	{
		System.out.println("session es null, no esta creada la sesion");
		response.sendRedirect("login");
	} 
	else 
	{
		String loggedIn = (String) session.getAttribute("loggedIn");
		//System.out.println("session.getAttribute(\"loggedIn\") " + session.getAttribute("loggedIn"));
		if (!loggedIn.equals("true")) 
		{
			//System.out.println("logeddIn en depositarCajaAhorro: " + loggedIn);
			response.sendRedirect("login");
		}
	}

	String id = (String) session.getAttribute("ID");
	cliente.cargarCliente(Integer.parseInt(id)); //carga el cliente con sus cuentas
%>

<HTML>
<HEAD>
<TITLE>Deposito Caja de Ahorro</TITLE>
</HEAD>
<BODY>
<CENTER><BR>
<BR>
<BR>

<h2>Deposito en Caja de Ahorro de <%
	out.println("<TD>" + cliente.getApellido() + "</TD>");
	out.println("<TD>" + cliente.getNombre() + "</TD>");
%>
</h2>
<FORM METHOD=POST ACTION=mostrarResultadoDeposito.jsp>

<TABLE border=1>
	<TR>
		<TH>
		<h3>su saldo actual</h3>
		</TH>
		<TH>
		<h3>Ingrese el monto a depositar</h3>
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
		<Td></Td>
		<Td><INPUT TYPE=SUBMIT> <!--				 <input align= left type="button" value="Efectuar deposito" >-->

		<input align="RIGHT" type="button" value="Cancelar"
			onclick="location.href = 'mostrarCuentasCliente.jsp'";
></Td>

	</TR>

</TABLE>
</FORM>

</CENTER>

</body>
</html>