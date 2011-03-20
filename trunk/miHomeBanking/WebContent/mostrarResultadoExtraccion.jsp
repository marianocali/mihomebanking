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

	double montoIngresado = Double.parseDouble((String) request.getParameter("montoIngresado"));
	
	elCliente.getCajaDeAhorro().extraccion(montoIngresado);

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Resultado Extracci&oacute;n</title>
</head>
<body>
		<h3 align="center"> Su extracci&oacute;n fue realizada y su nuevo saldo es de: 
		<% out.println(elCliente.getCajaDeAhorro().getSaldo() ); %>
		</h3>
				
				<input type="button" value="Volver"  onclick="location.href='mostrarCuentasCliente.jsp'">
</body>
</html>