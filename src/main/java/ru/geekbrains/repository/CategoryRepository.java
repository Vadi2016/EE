package ru.geekbrains.repository;


import ru.geekbrains.entity.Category;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private Connection con;

    public CategoryRepository(Connection con) {
        this.con = con;
    }

    public CategoryRepository() {

    }

    public List<Category> getAllCategories() {
        try {
            String selectAllCategories = "SELECT * FROM categories;";
            PreparedStatement selectAllCategoriesPreparedStmt =
                    con.prepareStatement(selectAllCategories);

            List<Category> categoryList = new ArrayList<>();
            ResultSet rs = selectAllCategoriesPreparedStmt.executeQuery();

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }
            return categoryList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void delete(Category category) {
        try (PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM categories WHERE id = ?;")) {
            deleteStmt.setLong(1, category.getId());
            deleteStmt.execute();
        } catch (SQLException e) {

        }
    }

    public void insert(Category category) {
        try (PreparedStatement insertStmt = con.prepareStatement(
                "INSERT INTO categories(name) VALUES (?);")) {
            insertStmt.setString(1, category.getName());
            insertStmt.execute();

        } catch (SQLException e) {

        }
    }

    public void save(Category category) throws SQLException {

        if (existsById(category.getId())) {
            try (PreparedStatement updateStmt = con.prepareStatement(
                    "update categories set name = ? where id = ?;")) {
                updateStmt.setString(1, category.getName());
                updateStmt.setLong(2, category.getId());
                updateStmt.execute();
            }
            return;
        }
        insert(category);
    }

    public boolean existsById(Long id) throws SQLException {
        if (id != null) {
            try (PreparedStatement stmt = con.prepareStatement(
                    "select 1 from categories where id = ? limit 1")) {
                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
        return false;
    }

}
