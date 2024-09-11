package org.example.commandeservice.dto.CommandeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.commandeservice.dto.LigneCommandeDto.LigneCommandeDtoResponse;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDtoResponse {
    private long id;
    private long idUser;
    private LocalDate date;
    private String statut;
    private Set<LigneCommandeDtoResponse> lignesCommande;

}
