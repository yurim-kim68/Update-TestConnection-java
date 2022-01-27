<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/common.css" />
<title>JSP 오라클 테스트</title>
</head>
<body>
<div class="content">
<% 
  	// 여기서 데이터 베이스에 접속

	Class.forName("oracle.jdbc.OracleDriver");
    
    Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe","shop","1234");
				
				
		int custno = 0; String custName = ""; Date date; String grade = "";
		String phone = ""; String address = ""; String city = "";
		String query = "select * from member_tbl_02";
		ResultSet result;
			
		result = con.prepareStatement(query).executeQuery();
			out.println("<table border='1'>");
			out.println("<tr><th>고객번호</th><th>이름</th><th>전화번호</th><th>주소</th><th>가입일</th><th>등급</th><th>도시</th><tr>");
		
		while(result.next()) {
			out.println("<tr>");
			custno = result.getInt("CUSTNO");
			custName = result.getString("CUSTNAME");
			phone = result.getString("PHONE");
			address = result.getString("ADDRESS");
			date = result.getDate("JOINDATE");
			grade = result.getString("GRADE");
			city = result.getString("CITY");
			out.println("<td>"+custno + "</td><td>" + custName + "</td><td>"+
					phone + "</td><td>"+ address + "</td><td>"+
					 date + "</td><td>" +grade + "</td><td>"+ city 
					+ "</td>");
			out.println("</tr>");
		}
			out.println("</table>");
			
%>

</div>
</body>
</html>
