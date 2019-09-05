package ru.geekbrains.dto;

import lombok.Data;
import ru.geekbrains.entity.Product;

@Data
public class ProductDTO {

    private Long id;

    private String title;

    private String desc;

    private int cost;

    public ProductDTO() {

    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.desc = product.getDesc();
        this.cost = product.getCost();
    }
}
