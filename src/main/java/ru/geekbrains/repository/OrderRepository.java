package ru.geekbrains.repository;


import ru.geekbrains.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class OrderRepository {

    public OrderRepository () {}


    @PersistenceContext(unitName = "ds")
    protected EntityManager em;


    @Transactional
    public Product merge(Product product) {
        return em.merge(product);
    }

    public List<Product> getProducts() {
        return em.createQuery("from Product ").getResultList();
    }
}
