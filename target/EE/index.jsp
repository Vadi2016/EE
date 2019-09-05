<html>
<jsp:include page="WEB-INF/views/head.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<body>
<jsp:include page="WEB-INF/views/nav.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>
<div class="container">
    <h1 class="mt-4 text-center">${ title }</h1>
</div>
</body>
</html>
