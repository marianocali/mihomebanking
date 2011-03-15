<%@ page session="false"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mybank.domain.*"%>
<%
	HttpSession session = request.getSession();
	if (session == null) {
		System.out.println("es null");
		response.sendRedirect("login");
	} else 
	{
		String loggedIn = (String) session.getAttribute("loggedIn");
		if (!loggedIn.equals("true"))
			response.sendRedirect("login");
	}

	String id = (String) session.getAttribute("ID");
	Cliente elCliente = new Cliente(id);
	CajaDeAhorro cajaDeAhorro = null;
	CuentaCorriente cuentaCorriente = null;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("JDBC driver loaded");
	} catch (ClassNotFoundException e) {
		System.out.println(e.toString());
	}
%>
<HTML>
	<HEAD>
		<TITLE>Bienvenido a la P�gina de sus Cuentas</TITLE>
	</HEAD>
<BODY>
	<CENTER><BR><BR><BR>

	<%
		String sql = "SELECT * FROM CLIENTES WHERE ID = '" + id + "'";

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {

				elCliente.setApellido(rs.getString(2));
				elCliente.setNombre(rs.getString(3));
				elCliente.setDocumento(rs.getString(4));
				elCliente.setCajaDeAhorro(rs.getString(5));
				elCliente.setCuentaCorriente(rs.getString(6));
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
		} catch (Exception e) {
		}
%>

	<h2> Bienvenido
		<%  
			out.println("<TD>" + elCliente.getApellido() + "</TD>");
			out.println("<TD>" + elCliente.getNombre()   + "</TD>");
		%>
	</h2>
	<h3> Estas son sus cuentas: </h3>

	<TABLE border=1>
		<TR>		
			<TH>Numero de Cuenta </TH> 
			<TH>Tipo de Cuenta</TH>
			<TH>Saldo</TH>				
		</TR>
		<TR>				
				<%
					
					if (elCliente.getCajaDeAhorro() != null)
					{
						out.println("<TD>" + elCliente.getCajaDeAhorro() + "</TD>");
					}						
				%>
			<Td>	
				Caja de Ahorro		
			</Td>
			<Td>	
				--buscar saldo--	
			</Td>
			<Td>	
				<A href = "bkc0904.jsp" > Depositar
				</A>    
						
			</Td>				
		</TR>	
	</TABLE>		
</CENTER>


</BODY>
</HTML>