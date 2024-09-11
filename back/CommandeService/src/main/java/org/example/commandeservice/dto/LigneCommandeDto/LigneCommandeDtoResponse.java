package org.example.commandeservice.dto.LigneCommandeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeDtoResponse {
    private long id;
    private long idProduit;
    private int quantite;
}
