package org.example.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @Enumerated
    private Categorie categorie;

    public Product(String name, String description, double price, int stock, Categorie categorie) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categorie = categorie;
    }
}
