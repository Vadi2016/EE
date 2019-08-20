package ru.geekbrains.jsf;


import ru.geekbrains.entity.Category;
import ru.geekbrains.repository.CategoryRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

//@SessionScoped
//@ManagedBean
@SessionScoped
@Named("categoryBean")
public class CategoryBean implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;

    private Category category;

//    @PostConstruct
//    public void init() {
//        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//
//        categoryRepository = new CategoryRepository((Connection) context.getAttribute("DBConnection"));
//    }


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

    public String saveCategory() {
        categoryRepository.merge(this.category);
        return "/categories.xhtml?faces-redirect=true";
    }

    public String createCategory() {
        this.category = new Category();
        return "/category.xhtml?faces-redirect=true";
    }

}
