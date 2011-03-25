package com.mybank.domain;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

	/**
	 * 
	 */

	private boolean esPrimerIngreso = true;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ValidaLoginBean validador = new ValidaLoginBean();

		String base = "/";
		String url = base + "login.jsp";

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (validador.login(userName, password)) {
			// send cookie to the browser
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", new String("true"));
			session.setAttribute("ID", new String(validador.getIdCliente(userName)));
			url = base + "mostrarCuentasCliente.jsp";
		} else {
			// envía mensaje de error
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedIn", new String("false"));
			url = base + "login.jsp";

			// sendLoginForm(response, true);
		}

		// String action = request.getParameter("action");
		//
		// if (action != null) {
		// if (action.equals("mostrarCuentasCliente"))
		// url = base + "mostrarCuentasCliente.jsp";
		// else if (action.equals("depositarCajaAhorro"))
		// url = base + "depositarCajaAhorro.jsp";
		// else if (action.equals("depositarCuentaCorriente"))
		// url = base + "depositarCuentaCorriente.jsp";
		// else if (action.equals("extraerCajaAhorro"))
		// url = base + "extraerCajaAhorro.jsp";
		// else if (action.equals("extraerCuentaCorriente"))
		// url = base + "extraerCuentaCorriente.jsp";
		// else if (action.equals("MostrarResultadoDepositoCajaDeAhorro"))
		// url = base + "MostrarResultadoDepositoCajaDeAhorro.jsp";
		// else if (action.equals("mostrarResultadoExtraccionCajaDeAhorro"))
		// url = base + "mostrarResultadoExtraccionCajaDeAhorro.jsp";
		// else if (action.equals("mostrarResultadoDepositoCuentaCorriente"))
		// url = base + "mostrarResultadoDepositoCuentaCorriente.jsp";
		// }
		RequestDispatcher requestDispatcher = getServletContext()
				.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

}
