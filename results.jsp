<%@ include file="aheader.jsp"%>


<%@ page  import="java.sql.*" import="databaseconnection.*" %>

<font size="" color="#cc0033">
<table cellpadding="10">
<tr><th>SoilMoisture<th>Temp<th>LDR<th>PH<th><font size="" color="#cc0033">Result</font><th>

<tr><tH><H4><%=request.getParameter("sm")%><tH><H4><%=request.getParameter("temp")%><tH><H4><%=request.getParameter("hum")%><tH><H4><%=request.getParameter("ph")%><tH><H4><%=request.getParameter("knn")%>

	
</table>
<br><br>r
<%@ include file="footer.jsp"%>