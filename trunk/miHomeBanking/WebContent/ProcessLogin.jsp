<%@ page session="false" %>
<jsp:useBean id="loginBean" scope="page" class="model1.LoginBean" />
<%
  if (loginBean.login(request.getParameter("userName"),
    request.getParameter("password")))
    request.getRequestDispatcher("welcome.jsp").forward(request, response);
  else
    //we have to use sendRedirect because we want to send the ?error part
    //to the Login.jsp page.
    //with RequestDispatcher.forward(), the URL will still be
    //the current URL
    response.sendRedirect("Login.jsp?error=yes");
%>
