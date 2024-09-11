package org.example.livraisonservice.dto;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.livraisonservice.enums.TypeLivraison;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivraisonDtoRequest {
    private long id_commande;
    private String etat;
    private LocalDate date;
    private TypeLivraison type;
}
