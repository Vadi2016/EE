package ru.geekbrains.jsf;


import ru.geekbrains.dto.CategoryDTO;
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

    private CategoryDTO category;

//    @PostConstruct
//    public void init() {
//        ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//
//        categoryRepository = new CategoryRepository((Connection) context.getAttribute("DBConnection"));
//    }


    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public String editCategory(CategoryDTO category) {
        this.category = category;
        return "/category.xhtml?faces-redirect=true";
    }

    public void deleteCategory(CategoryDTO category) {
        categoryRepository.delete(category);
    }

    public String saveCategory() {
        categoryRepository.merge(this.category);
        return "/categories.xhtml?faces-redirect=true";
    }

    public String createCategory() {
        this.category = new CategoryDTO();
        return "/category.xhtml?faces-redirect=true";
    }

}
