package ru.geekbrains.entity;


import lombok.Data;
import ru.geekbrains.dto.OrderDTO;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    public Order(OrderDTO orderDTO) {
        this.id = orderDTO.getId();
        this.status = orderDTO.getStatus();
    }
}
