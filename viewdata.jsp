<%@ include file="aheader.jsp"%>


<%@ page  import="java.sql.*" import="databaseconnection.*" %>

<font size="" color="#cc0033">
<table cellpadding="10">
<tr><th>Sno<th>SoilName<th>Soil Moisture<th>Temp<th>Humidity<th>PH<th>CropType


<% 
int temp=0;
	try{

	Connection con2 = databasecon.getconnection();
	Statement st5 = con2.createStatement();
	String sss1 = "select * from dataset";

	ResultSet rs1=st5.executeQuery(sss1);
	while(rs1.next())
	{	
		++temp;
		%>
		<tr><TH><H4><%=temp%><tH><H4><%=rs1.getString(2)%><tH><H4><%=rs1.getString(3)%><tH><H4><%=rs1.getString(4)%><tH><H4><H4><%=rs1.getString(5)%><tH><H4><H4><%=rs1.getString(6)%><tH><H4><H4><%=rs1.getString(7)%>
		<%
	}}
catch(Exception e1)
{
out.println(e1);
}

%>
</table>
<br><br>
<%@ include file="footer.jsp"%>