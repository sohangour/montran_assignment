<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<%!int sessionCounter, applicationCounter;%>
	<h3>Counter</h3>
	<hr>
	<%
	
	
		if (session.getAttribute("sessionCounter") == null) {
			session.setAttribute("sessionCounter", Integer.valueOf(0));
		}

		if (application.getAttribute("applicationCounter") == null) {
			application.setAttribute("applicationCounter", Integer.valueOf(0));
		}

		sessionCounter = Integer.valueOf(session.getAttribute("sessionCounter").toString());
		applicationCounter = Integer.valueOf(application.getAttribute("applicationCounter").toString());
	%>
	<h3>
		Session Count ::
		<%=sessionCounter%></h3>
	<br>
	<br>
	<h3>
		Application Count ::
		<%=applicationCounter%>
	</h3>
	
	<%
	session.setAttribute("sessionCounter", Integer.valueOf(sessionCounter + 1));
	application.setAttribute("applicationCounter", Integer.valueOf(applicationCounter + 1));
	%>
</body>

</html>