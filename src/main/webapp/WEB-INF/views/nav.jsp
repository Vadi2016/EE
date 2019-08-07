<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark">
    <a class="navbar-brand" href="#">JavaEE Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <%
            TreeMap<String, String> map = new TreeMap<>();
            map.put("about", "О нас");
            map.put("catalog", "Каталог");
            map.put("main", "Главная");
            pageContext.setAttribute("map", map.descendingMap());
        %>
        <ul class="navbar-nav mr-auto">
            <c:forEach var="item" items="${map}">
                <c:choose>
                    <c:when test="${title.equals(item.value)}">
                    <li class="nav-item active">
                        <a class="nav-link" href="${item.key}">${item.value}<span class="sr-only">(current)</span></a>
                    </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="${item.key}">${item.value}</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </c:forEach>
            <%--            <c:when test="${title.equals('Главная')}">--%>
            <%--            <li class="nav-item active">--%>
            <%--                <a class="nav-link" href="main">Главная<span class="sr-only">(current)</span></a>--%>
            <%--            </li>--%>
            <%--            </c:when>--%>
            <%--            <c:when test="${title.equals('Каталог')}">--%>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="catalog">Каталог</a>--%>
            <%--            </li>--%>
            <%--            </c:when>--%>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="about">О нас</a>--%>
            <%--            </li>--%>
            <%--        </ul>--%>
        </ul>
        <%--        </c:choose>--%>
        <ul class="navbar-nav">
            <c:if test="${title.equals('Корзина')}">
                <li class="nav-item active">
                    <a class="nav-link" href="cart">Корзина
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${!title.equals('Корзина')}">
                <li class="nav-item">
                    <a class="nav-link" href="cart">Корзина
                    </a>
                </li>
            </c:if>
        </ul>

    </div>
</nav>