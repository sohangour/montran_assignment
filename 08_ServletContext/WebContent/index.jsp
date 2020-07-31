<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Detail</title>
</head>
<body>
	<h3>Product</h3>
	<%!String productName = "";
	ArrayList<String> list = new ArrayList<>();%>

	<form action="" method="post">
		Product Name: <input type="text" name="productName"> <input
			type="submit" value="Print">
	</form>
	<hr>
	<%
		if (request.getParameter("productName") != null && !request.getParameter("productName").equals("")) {
		if (!list.contains(request.getParameter("productName"))) {
			list.add(request.getParameter("productName"));
			productName = list.toString();
			application.setAttribute("productList", productName);
		}
	}

	if (application.getAttribute("productList") != null) {
		productName = application.getAttribute("productList").toString();
	}
	%>
	suggestion :<%
		
	%>
	<%=productName%>
</body>
</html>
