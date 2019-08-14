package ru.geekbrains.repository;

import ru.geekbrains.entity.Product;
import ru.geekbrains.util.DBConnectionManager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

    private Connection con;

    @Inject
    private ServletContext servletContext;

    public ProductRepository() {

    }

    public ProductRepository(Connection con) {
        this.con = con;
    }

    @PostConstruct
    public void init() throws SQLException {
        this.con = (Connection) servletContext.getAttribute("DBConnection");
    }

    public List<Product> getProducts() {

        try {
            String selectAllProducts = "SELECT * FROM products;";
            PreparedStatement selectAllProductsPreparedStmt =
                    con.prepareStatement(selectAllProducts);

            List<Product> productList = new ArrayList<>();
            ResultSet rs = selectAllProductsPreparedStmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setTitle(rs.getString("title"));
                product.setDesc(rs.getString("descript"));
                product.setCost(rs.getInt("cost"));
                productList.add(product);
            }
            return productList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void delete(Product product) {

        try (PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM products WHERE id = ?;")) {
            deleteStmt.setLong(1, product.getId());
            deleteStmt.execute();
        } catch (SQLException e) {

        }
    }

    public void insert(Product product) {
        try (PreparedStatement insertStmt = con.prepareStatement(
                "INSERT INTO products(title, descript, cost) VALUES (?, ?, ?);")) {
            insertStmt.setString(1, product.getTitle());
            insertStmt.setString(2, product.getDesc());
            insertStmt.setLong(3, product.getCost());
            insertStmt.execute();

        } catch (SQLException e) {

        }
    }

    public void save(Product product) throws SQLException {

        if (existsById(product.getId())) {
            try (PreparedStatement updateStmt = con.prepareStatement(
                    "update products set title = ?, descript = ?, cost = ? where id = ?;")) {
                updateStmt.setString(1, product.getTitle());
                updateStmt.setString(2, product.getDesc());
                updateStmt.setInt(3, product.getCost());
                updateStmt.setLong(4, product.getId());
                updateStmt.execute();
            }
            return;
        }
        insert(product);
    }

    public boolean existsById(Long id) throws SQLException {
        if (id != null) {
            try (PreparedStatement stmt = con.prepareStatement(
                    "select 1 from products where id = ? limit 1")) {
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
        return false;
    }


}
