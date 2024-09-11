package org.example.productservice.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.productservice.model.Categorie;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoResponse {
    private long id_Product;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Categorie categorie;
}
