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
<div class="container pb-5 mt-5">
    <h3 class="mb-4">${product.title.toUpperCase()}</h3>
    <div class="text-center">
        <img src="${pageContext.request.contextPath}/static/img/noimage.gif" class="w-50" alt="">
    </div>
    <h4>Описание</h4>
    <p>${product.desc}</p>
    <h4 class="text-right pr-2">Цена: <strong>${product.cost} руб.</strong></h4>
    <a href="cart" class="btn btn-success btn-lg btn-block mt-3">Добавить в корзину</a>
</div>
</body>
</html>
