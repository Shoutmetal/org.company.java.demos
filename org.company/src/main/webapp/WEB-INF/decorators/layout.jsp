<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"></link>
<link href="${pageContext.request.contextPath}/resources/css/prism.css" rel="stylesheet"></link>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/java8.png" />
<link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet"></link>
<link href="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.css" rel="stylesheet"></link>

<script src="${pageContext.request.contextPath}/resources/js/jquery-2.2.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
<title>Java 8 - OCA</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container">
		<br />
		<br />
		<br />
		<sitemesh:write property='body' />
	</div>

	<jsp:include page="footer.jsp" />

	<script src="${pageContext.request.contextPath}/resources/js/prism-core.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/prism-clike.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/prism-csharp.js" type="text/javascript"></script>
</body>
</html>