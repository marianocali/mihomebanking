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
		 if (!loggedIn.equals("true"))
		 {
			response.sendRedirect("Login");
		 }
	}

	String id = (String) session.getAttribute("ID");
	Cliente elCliente = new Cliente(id);
	elCliente.cargarCliente(Integer.parseInt(id));		//carga el cliente con sus cuentas
	

%>

<HTML>
	<HEAD>
		<TITLE>Deposito Caja de Ahorro</TITLE>
	</HEAD>
	<BODY>
		<CENTER><BR> <BR> <BR>
		
		<h2> Deposito en Caja de Ahorro de  
			<%
				out.println("<TD>" + elCliente.getApellido() + "</TD>");
				out.println("<TD>" + elCliente.getNombre() + "</TD>");
			%> 
		</h2>

<TABLE border=1 >
	<TR>
		<TH> <h3>su saldo actual</h3></TH>
		<TH>  <h3>Ingrese el monto que desea depositar  </h3></TH>		
	</TR>
	<TR>		
			<%	
				out.println("<TD>" + elCliente.getCajaDeAhorro().getSaldo() + "</TD>");  
			%>
		<td>
			<FORM METHOD=POST ACTION=SimplePage.jsp>
				<INPUT TYPE=TEXT NAME=memoryHtml>
				<INPUT TYPE=SUBMIT>
			</FORM>			
			<input type="text" name=montoIngresado >
		</td>	 	
	</TR>
	<TR>
		<Td>  </Td>
			<Td>			
				<input align= left type="button" value="Efectuar deposito" >
				
				<input align = right type="button" value="Cancelar"  onclick="location.href='mostrarCuentasCliente.jsp'">
			</Td>
			
	</TR>
		
	</TABLE>
		</CENTER>

</body>
</html>