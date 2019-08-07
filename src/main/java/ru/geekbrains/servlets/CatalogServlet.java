package ru.geekbrains.servlets;


import ru.geekbrains.servlets.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    private final ProductRepository productRepository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Каталог");
        req.setAttribute("products", productRepository.getProducts());
        req.getRequestDispatcher("WEB-INF/views/catalog.jsp").forward(req, resp);


    }
}
