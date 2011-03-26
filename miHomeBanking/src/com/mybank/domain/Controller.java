package com.mybank.domain;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ValidaLoginBean validador = new ValidaLoginBean();
		HttpSession session = request.getSession(true);

		String base = "/";
		String url = base + "login.jsp";
		String action = request.getParameter("action");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		//si ya está logueado, saltea la parte de login
		if (!"true".equals(session.getAttribute("loggedIn"))) {
			if (validador.login(userName, password)) {
				session.setAttribute("loggedIn", new String("true"));
				session.setAttribute("ID", new String(validador
						.getIdCliente(userName)));
				url = base + "mostrarCuentasCliente.jsp";
				System.out.println("logeddIn en el if del Controller "
						+ session.getAttribute("loggedIn"));
			} else {
				session.setAttribute("loggedIn", new String("false"));
				url = base + "login.jsp";
				System.out.println("logeddIn en el else del Controller: "
						+ session.getAttribute("loggedIn"));
			}
		}

		if (action != null) {
			if (action.equals("mostrarCuentasCliente"))
				url = base + "mostrarCuentasCliente.jsp";
			else if (action.equals("depositarCajaDeAhorro"))
				url = base + "depositarCajaDeAhorro.jsp";
			else if (action.equals("depositarCuentaCorriente"))
				url = base + "depositarCuentaCorriente.jsp";
			else if (action.equals("extraerCajaDeAhorro"))
				url = base + "extraerCajaDeAhorro.jsp";
			else if (action.equals("extraerCuentaCorriente"))
				url = base + "extraerCuentaCorriente.jsp";			
			else if (action.equals("mostrarResultadoDepositoCajaDeAhorro"))
				url = base + "mostrarResultadoDepositoCajaDeAhorro.jsp";
			else if (action.equals("mostrarResultadoExtraccionCajaDeAhorro"))
				url = base + "mostrarResultadoExtraccionCajaDeAhorro.jsp";
			else if (action.equals("mostrarResultadoDepositoCuentaCorriente"))
				url = base + "mostrarResultadoDepositoCuentaCorriente.jsp";
			else if (action.equals("mostrarResultadoExtraccionCuentaCorriente"))
				url = base + "mostrarResultadoExtraccionCuentaCorriente.jsp";
			
			
		}
		System.out.println("url : " + url);
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher(url);

		requestDispatcher.forward(request, response);
	}

}
