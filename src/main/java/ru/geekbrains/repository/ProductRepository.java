package ru.geekbrains.repository;

import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository {

//    private Connection con;

//    @Inject
//    private ServletContext servletContext;

    public ProductRepository() {

    }

//    public ProductRepository(Connection con) {
//        this.con = con;
//    }

//    @PostConstruct
//    public void init() throws SQLException {
//        this.con = (Connection) servletContext.getAttribute("DBConnection");
//    }

    @PersistenceContext(unitName = "ds")
    protected EntityManager em;

    @Transactional
    public Product merge(Product product) {
        return em.merge(product);
    }

    public List<ProductDTO> getProducts() {


//        try {
//            String selectAllProducts = "SELECT * FROM products;";
//            PreparedStatement selectAllProductsPreparedStmt =
//                    con.prepareStatement(selectAllProducts);
//
//            List<Product> productList = new ArrayList<>();
//            ResultSet rs = selectAllProductsPreparedStmt.executeQuery();
//
//            while (rs.next()) {
//                Product product = new Product();
//                product.setId(rs.getLong("id"));
//                product.setTitle(rs.getString("title"));
//                product.setDesc(rs.getString("descript"));
//                product.setCost(rs.getInt("cost"));
//                productList.add(product);
//            }
//            return productList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;

        return em.createQuery("from Product ").getResultList();

    }

    @Transactional
    public void delete(Long id) {

//        try (PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM products WHERE id = ?;")) {
//            deleteStmt.setLong(1, product.getId());
//            deleteStmt.execute();
//        } catch (SQLException e) {
//
//        }

        try {
            Product attachedProduct = findById(id);
            if (attachedProduct != null) {
                em.remove(attachedProduct);
            }
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
    }

    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

//    public void insert(Product product) {
//        try (PreparedStatement insertStmt = con.prepareStatement(
//                "INSERT INTO products(title, descript, cost) VALUES (?, ?, ?);")) {
//            insertStmt.setString(1, product.getTitle());
//            insertStmt.setString(2, product.getDesc());
//            insertStmt.setLong(3, product.getCost());
//            insertStmt.execute();
//
//        } catch (SQLException e) {
//
//        }
//    }
//
//    public void save(Product product) throws SQLException {
//
//        if (existsById(product.getId())) {
//            try (PreparedStatement updateStmt = con.prepareStatement(
//                    "update products set title = ?, descript = ?, cost = ? where id = ?;")) {
//                updateStmt.setString(1, product.getTitle());
//                updateStmt.setString(2, product.getDesc());
//                updateStmt.setInt(3, product.getCost());
//                updateStmt.setLong(4, product.getId());
//                updateStmt.execute();
//            }
//            return;
//        }
//        insert(product);
//    }

    public boolean existsById(Long id) throws SQLException {
//        if (id != null) {
//            try (PreparedStatement stmt = con.prepareStatement(
//                    "select 1 from products where id = ? limit 1")) {
//                stmt.setLong(1, id);
//                ResultSet rs = stmt.executeQuery();
//                return rs.next();
//            }
//        }
//        return false;

        return findById(id) != null;
    }

    public List<ProductDTO> search(String search) {
        String qlString = "select product from Product product where product.title = (:name)";
        Query q = em.createQuery(qlString, ProductDTO.class);
        return q.setParameter("name", search).getResultList();
    }

    public List<ProductDTO> costGreaterThen(int cost) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ProductDTO> productCriteriaQuery = cb.createQuery(ProductDTO.class);
        Root<ProductDTO> productRoot = productCriteriaQuery.from(ProductDTO.class);
        Predicate predicate = cb.gt(productRoot.get("cost"), cost);
        productCriteriaQuery.where(predicate);
        return em.createQuery(productCriteriaQuery).getResultList();
    }
}
