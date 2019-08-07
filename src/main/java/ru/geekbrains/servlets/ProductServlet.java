package ru.geekbrains.servlets;


import ru.geekbrains.servlets.entity.Product;
import ru.geekbrains.servlets.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private final ProductRepository productRepository = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Товар");
        Long id = Long.parseLong(req.getQueryString().split("=")[1]);
        Product prod = null;
        for (Product pr : productRepository.getProducts()
        ) {
            System.out.println(pr.getId() + " | "  + id + " | " + pr.getId().equals(id));
            if (pr.getId() == id) {
                System.out.println(id);
                prod = pr;
            }
        }
//        Product prod = productRepository.getProducts().stream().filter(product -> id.equals(product.getId())).findAny().orElse(null);
        req.setAttribute("product", prod);
        req.getRequestDispatcher("WEB-INF/views/product.jsp").forward(req, resp);
    }
}
