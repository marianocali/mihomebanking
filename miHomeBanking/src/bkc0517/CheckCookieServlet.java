package bkc0517;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

// este ejercicio sirve para determinar si el browser del cliente acepta o no cookies
 

public class CheckCookieServlet extends HttpServlet {
  /**Process the HTTP Get request*/
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    if (request.getParameter("flag")==null) {
      // the first request
      Cookie cookie = new Cookie("browserSetting", "on");	//la cookie tiene 2 parametros clave y valor
      response.addCookie(cookie);
      String nextUrl = request.getRequestURI() + "?flag=1"; // agarra la url y le agrega un parametro
      out.println("<META HTTP-EQUIV=Refresh CONTENT=0;URL=" + nextUrl +">");  //limpia todo lo que tenes y pone esto nuevo
    }
    else {
      // the second request
      Cookie[] cookies = request.getCookies();
      int length = cookies.length;
      boolean cookieFound = false;
      for (int i=0; i<length; i++) {
        Cookie cookie = cookies[i];
        if (cookie.getName().equals("browserSetting") &&
          cookie.getValue().equals("on")) {
          cookieFound = true;
          break;
        }
      }
      if (cookieFound) {
        out.println("Your browser's cookie setting is on.");
      }
      else {
        out.println("Your browser does not support cookies or" +
          " the cookie setting is off.");
      }
    }
  }
  /**Process the HTTP Post request*/
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
