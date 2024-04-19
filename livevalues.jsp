<%@ include file="aheader.jsp"%>


<%@ page  import="java.sql.*" import="databaseconnection.*" %>

<font size="" color="#cc0033">
<table cellpadding="10">



		<form action="getKNN.jsp">
		
		<tr><td>Soil Moisture<td><input type="number" name="sm" required>
		<tr><td>Temp<td><input type="number" name="temp" required>
		<tr><td>LDR<td><input type="number" name="humd" required>
		<tr><td>PH<td><input type="number" name="ph" required>
		



<tr><td></td><td><input type="submit" value="Prediction"></td>
</form>



</table>
<br><br>
<%@ include file="footer.jsp"%>