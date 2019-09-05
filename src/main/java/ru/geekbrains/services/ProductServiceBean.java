package ru.geekbrains.services;

import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ProductServiceBean implements ProductServiceLocalBean {

    @EJB
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void merge(ProductDTO productDTO) {
        productRepository.merge(new Product(productDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    @Transactional
    public ProductDTO findById(Long id) {
        return new ProductDTO(productRepository.findById(id));
    }

    @Override
    @Transactional
    public boolean existsById(Long id) throws SQLException {
        return productRepository.existsById(id);
    }

    @Override
    @Transactional
    public List<ProductDTO> getAllProducts() {
        return productRepository.getProducts();
    }

    @Override
    public List<ProductDTO> search(String search) {
        return productRepository.search(search);
    }

    @Override
    public List<ProductDTO> costGreaterThen(int cost) {
        return productRepository.costGreaterThen(cost);
    }
}
