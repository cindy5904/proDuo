package org.example.livraisonservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.livraisonservice.enums.TypeLivraison;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_commande;
    private String etat;
    private LocalDate date;
    @Enumerated
    private TypeLivraison type;

}
