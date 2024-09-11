package org.example.commandeservice.dto.CommandeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commandeservice.dto.LigneCommandeDto.LigneCommandeDtoRequest;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDtoRequest {
    private long idUser; // ID de l'utilisateur
    private LocalDate date;
    private String statut;
    private Set<LigneCommandeDtoRequest> lignesCommande;
}
