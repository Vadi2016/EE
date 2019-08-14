package ru.geekbrains.entity;

public class Product {

    private Long id;
    private String title;
    private String desc;
    private int cost;

    public Product()
    {}
    public Product(Long id, String title, String desc, int cost) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
