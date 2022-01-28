<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객명단</title>
</head>
<body>
<ul>
	<li>신규고객등록</li>
	<li>고객리스트</li>
</ul>
<h2>고객리스트</h2>

<%
String url ="jdbc:oracle:thin:@localhost:1521:xe";
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection(url,"shop","1234");
ResultSet rs = conn.prepareStatement("select CUSTNO,CUSTNAME,PHONE from member_tbl_02").executeQuery();
%>
<table border='1'>
<% while( rs.next()) {
	%>
	<tr><td><%=rs.getInt("custno")%></td><td>
	<%=rs.getString("custname")%></td><td>
	<%=rs.getString("phone")%></td>
	</tr>
	<%}%>
</table>


</body>
</html>
