<jsp:useBean id="theBean" class="bkc1010.SQLToolBean">
<%
  try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    			   
  }
  catch (Exception e) {
    out.println(e.toString());
  }
%>
</jsp:useBean>
<jsp:setProperty name="theBean" property="userName"/>
<jsp:setProperty name="theBean" property="password"/>
<jsp:setProperty name="theBean" property="connectionUrl" value="jdbc:oracle:thin:@localhost:1521:xe"/>
<jsp:setProperty name="theBean" property="sql"/>
<HTML>
<HEAD>
<TITLE>SQL Tool</TITLE>
</HEAD>
<BODY>
<BR><H2>SQL Tool</H2>
<BR>Please type your SQL statement in the following box.
<BR>
<BR><FORM METHOD=POST>
<INPUT TYPE=HIDDEN NAME=userName VALUE="<jsp:getProperty name="theBean" property="userName"/>">
<INPUT TYPE=HIDDEN NAME=password VALUE="<jsp:getProperty name="theBean" property="password"/>">
<TEXTAREA NAME=sql COLS=80 ROWS=8>
<jsp:getProperty name="theBean" property="sql"/>
</TEXTAREA>
<BR>
<INPUT TYPE=SUBMIT>
</FORM>
<BR>
<HR>
<BR>
<%= theBean.getResult() %>
</BODY>
</HTML>
