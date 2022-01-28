<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ToDo List</title>
</head>
<body>
<form action="todo.jsp">
Add new item: <input type="text" name="todoItem">
<input type="submit" value="제출">
</form>
<%
	List<String> nameList = 
		(List<String>)session.getAttribute("myToDoList");
	if( nameList == null) {
		nameList = new ArrayList<String>();
	}

	String pName = request.getParameter("todoItem");

	//String sName = (String)session.getAttribute("myToDoList");
	if( pName != null && !pName.isEmpty()) {
		
		nameList.add(pName);
		
		session.setAttribute("myToDoList", nameList);
	}
	
%>
<%-- <p>이름은: <%= session.getAttribute("myToDoList") %> 입니다.</p> --%>
<%
	for(String name : nameList ) {
		out.println(name + "<br>");
	}
%>

<p>이름은: <%= pName %> 입니다.</p>



</body>
</html>
