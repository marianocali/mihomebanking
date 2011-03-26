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
	String mensajeOperacion = "";
	boolean isExtraccionExitosa = cliente.getCajaDeAhorro().extraccion(montoIngresado);
	if (!isExtraccionExitosa)
		mensajeOperacion = "Su operación no pudo ser procesada, su saldo es de: " + cliente.getCajaDeAhorro().getSaldo() + " y Usted quiso retirar " + montoIngresado;
	else
		mensajeOperacion = "Su operación fue realizada con exito y su nuevo saldo es de: " + cliente.getCajaDeAhorro().getSaldo();

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Resultado Extracci&oacute;n</title>
</head>
<body>
		<h3 align="center"> <% out.println(mensajeOperacion); %></h3>
				
				<input type="button" value="Volver"  
				onclick="location.href='http://localhost:8081/miHomeBanking/mostrarCuentasCliente?action=mostrarCuentasCliente'">
</body>
</html>