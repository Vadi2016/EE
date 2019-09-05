package ru.geekbrains.services;

import ru.geekbrains.dto.ProductDTO;


import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface ProductServiceLocalBean {

    void merge(ProductDTO productDTO);

    void delete(Long id);

    ProductDTO findById(Long id);

    boolean existsById(Long id) throws SQLException;

    List<ProductDTO> getAllProducts();

    List<ProductDTO> search(String search);

    List<ProductDTO> costGreaterThen(int cost);


}
