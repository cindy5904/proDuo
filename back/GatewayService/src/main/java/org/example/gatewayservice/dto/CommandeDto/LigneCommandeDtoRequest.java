package org.example.gatewayservice.dto.CommandeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeDtoRequest {
    private long idProduit;
    private int quantite;
}
