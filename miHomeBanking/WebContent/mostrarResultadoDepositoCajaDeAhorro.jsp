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
		 if (!loggedIn.equals("true"))
		 {
			response.sendRedirect("Login");
		 }
	}

	String id = (String) session.getAttribute("ID");
	cliente.cargarCliente(Integer.parseInt(id));		//carga el cliente con sus cuentas

	double montoIngresado = Double.parseDouble((String) request.getParameter("montoIngresado"));
	
	cliente.getCajaDeAhorro().deposito(montoIngresado);

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Resultado Depósito</title>
</head>
<body>
		<h3 align="center"> Su depósito fue realizado y su nuevo saldo es de: 
		<% out.println(cliente.getCajaDeAhorro().getSaldo() ); %>
		</h3>
				
				<input type="button" value="Volver"  onclick="location.href='mostrarCuentasCliente.jsp'">
</body>
</html>