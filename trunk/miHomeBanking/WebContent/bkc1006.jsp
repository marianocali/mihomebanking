<jsp:useBean id="theBean" class="bkc1003.CalculatorBean"/>
<%
  int i = 2;
%>
<jsp:setProperty name="theBean" property="memory" value="<%= 100 * i %>"/>
The value of memory is <jsp:getProperty name="theBean" property="memory"/>
