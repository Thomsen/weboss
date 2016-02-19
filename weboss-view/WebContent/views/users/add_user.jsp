<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../template/res_template.jsp" %> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	add user
	<form action="add_user" method="POST">
		<fmt:message key="user.screenname" />：<input type="text" name="nickname" /> <br />
		<fmt:message key="user.name" />：<input type="text" name="username" /> <br />
		<fmt:message key="user.password" />：<input type="password" name="password" /> <br />
		<fmt:message key="user.confirmpassword" />：<input type="password" /> <br />
		<fmt:message key="user.birthday" />：<select id="datesel"></select> <br />
		<fmt:message key="user.gender" />：<input type="radio" name="gender">
		<fmt:message key="user.male" /><input type="radio" name="gender">
		<fmt:message key="user.female" /><br />
		<fmt:message key="user.email" />：<input type="text" name="email" /> <br />
		<fmt:message key="user.phone" />：<input type="text"  name="phone" /> <br />
		<fmt:message key="user.address" />：<input type="text" name="city" /> <br />
		<input type="submit" value="<fmt:message key="common.submit" />" />
	</form>
</body>
</html>