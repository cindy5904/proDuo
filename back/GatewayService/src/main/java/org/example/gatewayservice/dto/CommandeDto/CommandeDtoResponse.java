package org.example.gatewayservice.dto.CommandeDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
