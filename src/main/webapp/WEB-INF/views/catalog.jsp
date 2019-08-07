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
    <h1 class="mt-4 mb-5 text-center">${ title }</h1>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-lg-3 mb-3">
                <div class="card">
                    <div class="card-header">
                        <h5 class="card-title">${product.title.toUpperCase()}</h5>
                    </div>
                    <div class="card-body text-right">
                        <img src="${pageContext.request.contextPath}/static/img/noimage.gif" class="card-img-top" alt="...">
                        <span>Цена: <strong>${product.cost} руб.</strong></span>
                        <div class="btn-toolbar mt-3">
                            <a href="product?id=${product.id}" class="btn btn-primary mr-auto">Подробнее</a>
                            <a href="cart" class="btn btn-success">Добавить</a>
                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
