package ru.geekbrains.entity;

import lombok.Data;
import ru.geekbrains.dto.CategoryDTO;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Category(CategoryDTO cat) {
        this.id = cat.getId();
        this.name = cat.getName();
    }
}
