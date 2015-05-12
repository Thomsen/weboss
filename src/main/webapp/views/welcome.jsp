<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
	
	<title><fmt:message key="welcome.title" /></title>
</head>
<body>
<div class="container">  
	<h1>
		<fmt:message key="welcome.title" />
	</h1>
	<p>
		Locale = ${pageContext.response.locale}
	</p>
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=zh_cn">cn</a></li>
	</ul>
	<ul>
		<li><a href="account">@Controller Example</a></li>
		<li><a href="user">@User Controller</a></li>
		<li><a href="views/users/new_contact.jsp">@Contact Rest</a></li>
	</ul>
</div>
</body>
</html>