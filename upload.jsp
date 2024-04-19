<%@ include file="aheader.jsp"%>

<%@ page   import="CT.XLToDB" %>


<%@ page  import="java.sql.*" import="databaseconnection.*" %>

<%

try{
Connection con1 = databasecon.getconnection();
Statement st1 = con1.createStatement();
st1.executeUpdate("delete from dataset")	;
}


catch(Exception e1)
{
out.println(e1.getMessage());
}

%>



<%
String file = request.getParameter("file");
int t=0;
try
{
	 t=XLToDB.insertRecords(file);
	}
catch(Exception e1)
{
out.println(e1);
}

%>
<h2><%=t%> records uploaded from "<%=file%>"</h2>

<br><br>
<%@ include file="footer.jsp"%>