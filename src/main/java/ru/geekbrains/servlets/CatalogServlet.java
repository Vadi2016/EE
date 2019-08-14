package ru.geekbrains.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {


//    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");

//        productRepository = new ProductRepository(con);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Каталог");
//        req.setAttribute("products", productRepository.getProducts());
        req.getRequestDispatcher("WEB-INF/views/catalog.jsp").forward(req, resp);

    }
}
