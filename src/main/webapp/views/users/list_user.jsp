<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.List,com.anyuan.thomweboss.model.user.User"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<%@ include file="../template/res_template.jsp" %>
<%
	List<User> listUser = (List<User>) request.getAttribute("listuser");
	// System.out.println("liseruser " + listUser.get(0).getUsername());
	
	if (null != listUser) {
	    for (User u : listUser) {
		    pageContext.setAttribute("user", u);
		}    
	}
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="title.listuser" /></title>
</head>
<body>
	<button name="register" onclick="location.href='user/add'"  ><fmt:message key="common.add" /></button>
	<table>
		<thead>
			<tr>
				<th><fmt:message key="user.id" /></th>
				<th><fmt:message key="user.name" /></th>
				<th><fmt:message key="user.screenname" /></th>
				<th><fmt:message key="user.createtime" /></th>
				<th><fmt:message key="user.lastlogintime" /></th>
				<th><fmt:message key="user.gender" /></th>
				<th><fmt:message key="user.birthday" /></th>
				<th><fmt:message key="user.email" /></th>
				<th><fmt:message key="user.phone" /></th>
				<th><fmt:message key="user.address" /></th>
				<th><fmt:message key="user.organization" /></th>
				<th><fmt:message key="user.role" /></th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<!--  
					<td>
						<%-- =listUser.get(0).getUsername() --%>
					</td>
					-->
					<!-- el  
					<td>${user.id }</td>
					<td>${user.username }
					-->
				</tr>
				<%
					if (null != listUser) {
					    for (User u : listUser) {
						    out.print("<tr>");
							out.print("<td>" + u.getId() + "</td>");
							out.print("<td> <a href=\"user/add\"> " + u.getUsername() + "</a></td>");
							out.print("<td>" + u.getNickname() + "</td>");
							out.print("<td>" + u.getCreatetime() + "</td>");
							out.print("<td>" + u.getLogintime() + "</td>");
							out.print("<td>" + u.getGender() + "</td>");
							out.print("<td>" + u.getBirthday() + "</td>");
							out.print("<td>" + "email" + "</td>");
							out.print("<td>" + "phone" + "</td>");
							out.print("<td>" + "address" + "</td>");
							out.print("<td>" + "group relation" + "</td>");
							out.print("<td>" + "role relation" + "</td>");
						    out.print("/<tr>");
						}    
					}
				%>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>