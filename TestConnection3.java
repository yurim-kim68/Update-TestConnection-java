<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/common.css" />
<title>JSP 오라클 테스트</title>
</head>
<body>
	<div class="container">
<div class="content">
<form action="TestConnect.jsp">
<input type="text" name="name"><input type="submit" value="검색">
</form>

<% 
	String name = request.getParameter("name");
	out.println("이름은:" + name + "입니다. <br>");
	
	Class.forName("oracle.jdbc.OracleDriver");
    Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe","shop","1234");
				
				
		int custno = 0; String custName = ""; int price = 0;
		int sum = 0;
		String phone = ""; String address = ""; String city = "";
		String query;
		if(name == null || name.isEmpty()) {
		query= "select mo.custno, mb.custname, mo.price from money_tbl_02 mo, member_tbl_02 mb where mo.custno = mb.custno";
	} else {
		query = "select mo.custno, mb.custname, mo.price " + 
			"from money_tbl_02 mo, member_tbl_02 mb " + 
			"where mo.custno = mb.custno and " + 
			"mb.custname = '" + name +"'";
		}
		ResultSet result;
			
		result = con.prepareStatement(query).executeQuery();
		while(result.next()) {
			custno = result.getInt("CUSTNO");
			custName = result.getString("CUSTNAME");
			price = result.getInt("PRICE");
			sum += price;
			out.println(""+custno + " " + custName + " " + price + "<br>");
		}
%>

		<p><%= name %> 님의 매출 총합계는 <%= sum %>입니다.</p>

</div>
</div>
</body>
</html>
