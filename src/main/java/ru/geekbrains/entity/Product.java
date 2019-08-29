package ru.geekbrains.entity;


import lombok.Data;
import ru.geekbrains.dto.ProductDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description", unique = true)
    private String desc;

    @Column(name = "cost")
    private int cost;

    public Product(ProductDTO productDTO) {
        this.id = productDTO.getId();
        this.title = productDTO.getTitle();
        this.desc = productDTO.getDesc();
        this.cost = productDTO.getCost();
    }
}
