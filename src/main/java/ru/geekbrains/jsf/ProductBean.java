package ru.geekbrains.jsf;

import ru.geekbrains.dto.ProductDTO;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.services.ProductServiceLocalBean;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("productsBean")
public class ProductBean implements Serializable {

    @EJB
    private ProductServiceLocalBean productServiceLocalBean;

    private ProductDTO product;

    private String search;

    private int filterCost;

    public List<ProductDTO> getAllProduct() {
        if (this.search != null  && !this.search.equals("")) {
            return productServiceLocalBean.search(this.search);
        }

        if (this.filterCost != 0) {
            return productServiceLocalBean.costGreaterThen(this.filterCost);
        }

        return productServiceLocalBean.getAllProducts();
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public String editProduct(ProductDTO product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDTO product) {
        productServiceLocalBean.delete(product.getId());
    }

    public String save() {
        productServiceLocalBean.merge(this.product);
        return "/products.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.product = new ProductDTO();
        return "/product.xhtml?faces-redirect=true";
    }

    public String getSearch() {
        return search;
    }
    public void setSearch(String search) {
        this.search = search;
    }

    public int getFilterCost() {
        return filterCost;
    }
    public void setFilterCost(int filterCost) {
        this.filterCost = filterCost;
    }
}
