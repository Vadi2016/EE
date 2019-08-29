package ru.geekbrains.repository;


import ru.geekbrains.dto.CategoryDTO;
import ru.geekbrains.entity.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;


@ApplicationScoped
@Named
public class CategoryRepository {

    //    private Connection con;
//
//    public CategoryRepository(Connection con) {
//        this.con = con;
//    }
//
    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    public CategoryRepository() {
    }

    @Transactional
    public CategoryDTO merge(CategoryDTO category) {
        return em.merge(category);
    }


    public List<CategoryDTO> getAllCategories() {
//        try {
//            String selectAllCategories = "SELECT * FROM categories;";
//            PreparedStatement selectAllCategoriesPreparedStmt =
//                    con.prepareStatement(selectAllCategories);
//
//            List<Category> categoryList = new ArrayList<>();
//            ResultSet rs = selectAllCategoriesPreparedStmt.executeQuery();
//
//            while (rs.next()) {
//                Category category = new Category();
//                category.setId(rs.getLong("id"));
//                category.setName(rs.getString("name"));
//                categoryList.add(category);
//            }
//            return categoryList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;

        return em.createQuery("from Category ").getResultList();
    }

    @Transactional
    public void delete(CategoryDTO category) {
//        try (PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM categories WHERE id = ?;")) {
//            deleteStmt.setLong(1, category.getId());
//            deleteStmt.execute();
//        } catch (SQLException e) {
//
//        }

        try {
            CategoryDTO attachedCategory = findById(category.getId());
            if (attachedCategory != null) {
                em.remove(attachedCategory);
            }
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

//    public void insert(Category category) {
//        try (PreparedStatement insertStmt = con.prepareStatement(
//                "INSERT INTO categories(name) VALUES (?);")) {
//            insertStmt.setString(1, category.getName());
//            insertStmt.execute();
//
//        } catch (SQLException e) {
//
//        }
//    }


    public CategoryDTO findById(Long id) {
        return em.find(CategoryDTO.class, id);
    }

//    public void save(Category category) throws SQLException {
//
//        if (existsById(category.getId())) {
//            try (PreparedStatement updateStmt = con.prepareStatement(
//                    "update categories set name = ? where id = ?;")) {
//                updateStmt.setString(1, category.getName());
//                updateStmt.setLong(2, category.getId());
//                updateStmt.execute();
//            }
//            return;
//        }
//        insert(category);
//    }

    public boolean existsById(Long id) throws SQLException {
//        if (id != null) {
//            try (PreparedStatement stmt = con.prepareStatement(
//                    "select 1 from categories where id = ? limit 1")) {
//                stmt.setLong(1, id);
//                ResultSet rs = stmt.executeQuery();
//                return rs.next();
//            }
//        }
//        return false;
        return findById(id) != null;
    }

}
