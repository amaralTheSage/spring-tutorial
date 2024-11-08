package com.projetin.products;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products") // necessário somente se for especificar um nome para a tabela. Padrão = product (nome do modelo)
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String title;

    @NotNull
    private float price;

    public Product(){}

    public Product(float price, String title) {
        this.price = price;
        this.title = title;
    }
}
