<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<link rel="stylesheet" type="text/css" href="<c:url value="/library/extjs-3.4.0/resources/css/ext-all.css" />" />
<script type="text/javascript" src="<c:url value="/library/extjs-3.4.0/adapter/ext/ext-base.js" />" ></script>
<script type="text/javascript" src="<c:url value="/library/extjs-3.4.0/ext-all.js" />" ></script>
