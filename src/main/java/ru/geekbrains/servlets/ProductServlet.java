package ru.geekbrains.servlets;


import ru.geekbrains.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

//    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");

//        productRepository = new ProductRepository(con);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Товар");
        Long id = Long.parseLong(req.getQueryString().split("=")[1]);
        Product prod = null;
//        for (Product pr : productRepository.getProducts()
//        ) {
//            System.out.println(pr.getId() + " | "  + id + " | " + pr.getId().equals(id));
//            if (pr.getId() == id) {
//                System.out.println(id);
//                prod = pr;
//            }
//        }
//        Product prod = productRepository.getProducts().stream().filter(product -> id.equals(product.getId())).findAny().orElse(null);
        req.setAttribute("product", prod);
        req.getRequestDispatcher("WEB-INF/views/product.jsp").forward(req, resp);
    }
}
