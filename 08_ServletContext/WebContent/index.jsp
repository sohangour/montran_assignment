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
	int numberCheck = 0;%>

	<form action="" method="post">
		Product Name: <input type="text" name="productName"> <input
			type="submit" value="Print">
	</form>
	<hr>
	<%
		if (request.getParameter("productName") != null && !request.getParameter("productName").equals("")) {
		if (productName.isEmpty()) {
			productName = request.getParameter("productName");
			application.setAttribute("productList", productName);
		} else {
			productName = application.getAttribute("productList") + "," + request.getParameter("productName");
			application.setAttribute("productList", productName);
		}

	}

	if (application.getAttribute("productList") != null) {
		productName = application.getAttribute("productList").toString();
	}
	%>
	suggestion :[<%
		
	%>
	<%=productName%>]
</body>
</html>