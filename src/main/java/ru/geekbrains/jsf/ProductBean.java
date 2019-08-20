package ru.geekbrains.jsf;

import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named("productsBean")
public class ProductBean implements Serializable {

    @Inject
    private ProductRepository productRepository;

    private Product product;

    private String search;


    private int filterCost;

    public List<Product> getAllProduct() {
        if (this.search != null  && !this.search.equals("")) {
            return productRepository.search(this.search);
        }

        if (this.filterCost != 0) {
            return productRepository.costGreaterThen(this.filterCost);
        }

        return productRepository.getProducts();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public String save() {
        productRepository.merge(this.product);
        return "/products.xhtml?faces-redirect=true";
    }

    public String createProduct() {
        this.product = new Product();
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
