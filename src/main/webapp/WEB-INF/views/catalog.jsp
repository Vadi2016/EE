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
                    <img src="${pageContext.request.contextPath}/static/img/noimage.gif" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${product.title.toUpperCase()}</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of
                            the card's content.</p>
                        <span>Цена: ${product.cost} руб.</span>
                        <div class="text-center">
                            <a href="product?id=${product.id}" class="btn btn-primary mt-3">Подробнее</a>
                            <a href="cart" class="btn btn-success mt-3">Добавить в корзину</a>
                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
