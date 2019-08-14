package ru.geekbrains.jsf;


import ru.geekbrains.entity.Category;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.CategoryRepository;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@ManagedBean
public class CategoryBean {

    private CategoryRepository categoryRepository;

    private Category category;

    @PostConstruct
    public void init() {
        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        categoryRepository = new CategoryRepository((Connection) context.getAttribute("DBConnection"));
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    public String saveCategory() throws SQLException {
        categoryRepository.save(getCategory());
        return "/categories.xhtml?faces-redirect=true";
    }

    public String createCategory() {
        this.category = new Category();
        return "/category.xhtml?faces-redirect=true";
    }

}
