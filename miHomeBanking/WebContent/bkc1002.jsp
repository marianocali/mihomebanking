<jsp:useBean id="theBean" class="bkc1001.CalculatorBean"/>
<HTML>
<HEAD>
</HEAD>
<BODY>
<%
  int i = 4;
  int j = theBean.doubleIt(i);
  out.print("2*4=" + j);
%>
</BODY>
</HTML>