<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>
<jsp:include page="nav.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<div class="container">
    <h1 class="mt-4 text-center">${ title }</h1>
</div>
</body>
</html>
