package ru.geekbrains.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Главная</h1>");
        resp.getWriter().println("<a href=\"main\">Главная</a>");
        resp.getWriter().println("<a href=\"catalog\">Каталог</a>");
        resp.getWriter().println("<a href=\"product\">Товар</a>");
        resp.getWriter().println("<a href=\"cart\">Корзина</a>");
        resp.getWriter().println("<a href=\"order\">Оформление заказа</a>");
    }
}
