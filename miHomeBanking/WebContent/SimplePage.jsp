<jsp:useBean id="Bean1" class="bkc1003.CalculatorBean"/>
<jsp:setProperty name="Bean1" property="memory" param="memoryHtml"/>
<jsp:setProperty name="Bean1" property="saldo" param="memoryHtml"/>
<%
	
%>
The value of memory is <jsp:getProperty name="Bean1" property="memory"/> <br>
The value of saldo is  <jsp:getProperty name="Bean1" property="saldo"/>