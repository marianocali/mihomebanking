<jsp:useBean id="theBean" class="bkc1003.CalculatorBean"/>
<jsp:setProperty name="theBean" property="memory" param="memoryHtml"/>
The value of memory is <jsp:getProperty name="theBean" property="memory"/>
