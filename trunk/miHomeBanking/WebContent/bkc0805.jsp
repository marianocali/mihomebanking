<HTML>
<HEAD>
  <TITLE>Displaying the server time</TITLE>
</HEAD>
<BODY>
Welcome. The server time is now
<%
  java.util.Calendar now = java.util.Calendar.getInstance();
  int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
  int minute = now.get(java.util.Calendar.MINUTE);

  if (hour<10)
    out.println("0" + hour);
  else
    out.println(hour);

  out.println(":");

  if (minute<10)
    out.println("0" + minute);
  else
    out.println(minute);

%>
</BODY>
</HTML>
