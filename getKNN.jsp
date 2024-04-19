<%@ include file="aheader.jsp" %>
<%@ page import="java.io.*"%>
<%@ page import="databaseconnection.*,java.util.*,java.math.*,KNN.*"%>
<%@ page import="java.sql.*"%>

<%!String  thisLine = null; 
StringBuffer sb1=null; 
String unm=null,fid=null,fnm=null,pk0,pku,sk2;
int i=0;
File f;
ResultSet rs6;
%>
  
<%


 
	
	String sm=request.getParameter("sm");
		String temp=request.getParameter("temp");
	String humd=request.getParameter("humd");
		String ph=request.getParameter("ph");


	

	String[] cmd = {
      "python",
      "D:\\python\\Predict.py",sm,
	 temp,
	  humd,
	ph};

	  Process p = Runtime.getRuntime().exec(cmd);
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String res = in.readLine();
System.out.println("value is : "+res);

session.setAttribute("soil",sm);
session.setAttribute("temp",temp);
session.setAttribute("hum",humd);
session.setAttribute("ph",ph);

session.setAttribute("knn",res);
	
	response.sendRedirect("results.jsp?sm="+sm+"&temp="+temp+"&hum="+humd+"&ph="+ph+"&knn="+res);

      
%>
