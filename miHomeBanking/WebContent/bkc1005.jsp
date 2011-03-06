<jsp:useBean id="theBean" class="bkc1003.CalculatorBean"/>
<%
  theBean.setMemory(987);
%>
The value of memory is <%= theBean.getMemory()%>
