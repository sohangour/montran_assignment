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
	<%!String productName = "";%>

	<form action="" method="post">
		Product Name: <input type="text" name="productName"> <input
			type="submit" value="Print">
	</form>
	<hr>
	<%
		if (request.getParameter("productName") != null && !request.getParameter("productName").equals("")) {
		System.out.println("inside top if ::" + request.getParameter("productName"));

		if (productName.isEmpty()) {
			productName = request.getParameter("productName");
			application.setAttribute("productList", productName);
		} else if (!application.getAttribute("productList").toString().contains(request.getParameter("productName"))) {
			productName = application.getAttribute("productList") + "," + request.getParameter("productName");
			application.setAttribute("productList", productName);
		}

	}

	if (application.getAttribute("productList") != null) {
		productName = application.getAttribute("productList").toString();
		System.out.print("inside if ::" + productName);
	}
	%>
	suggestion :[<%
		
	%>
	<%=productName%>]
</body>
</html>
