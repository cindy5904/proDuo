package org.example.gatewayservice.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.gatewayservice.enums.Categorie;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoRequest {
    private String name;
    private String description;
    private double price;
    private int stock;
    private Categorie categorie;
}
