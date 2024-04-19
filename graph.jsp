<%@include file="aheader.jsp"%>

<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>
<%@ page import="org.jfree.data.*" %>
<%@ page import="org.jfree.data.jdbc.JDBCCategoryDataset"%>


<%@ page import="java.io.*"%>
<%@ page import="databaseconnection.*"%>
<%@ page import="java.sql.*"%>




<%

int rice=0,wheat=0,corn=0,sweetcorn=0;
Connection con2 = databasecon.getconnection();

Statement st=con2.createStatement();
Statement s5=con2.createStatement();
//s5.executeUpdate("delete from graphs");







String query="SELECT *from graphs";
JDBCCategoryDataset dataset=new JDBCCategoryDataset("jdbc:mysql://localhost:3306/crop-knn",
"com.mysql.jdbc.Driver","root","root");

dataset.executeQuery(query);
JFreeChart chart = ChartFactory .createBarChart3D(
"Crop-Detecting Analysis", 
"Crop Type", 
"Crop Values",
dataset, 
PlotOrientation.VERTICAL,true, true, false);
try
{
ChartUtilities.saveChartAsJPEG(new File("D:\\Apache Software Foundation\\webapps\\Crop-NB\\images\\chart.jpg"), chart, 400, 300);

}
catch (IOException e)
{
	e.printStackTrace();
System.out.println("");
}

%>
<center><img src="images/chart.jpg" height="500px" width="500px" >



<%@ include file="footer.jsp" %> 
 

