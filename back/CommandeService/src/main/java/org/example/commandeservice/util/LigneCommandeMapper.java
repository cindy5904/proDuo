package org.example.commandeservice.util;

import org.example.commandeservice.dto.CommandeDto.CommandeDtoRequest;
import org.example.commandeservice.dto.CommandeDto.CommandeDtoResponse;
import org.example.commandeservice.dto.LigneCommandeDto.LigneCommandeDtoRequest;
import org.example.commandeservice.dto.LigneCommandeDto.LigneCommandeDtoResponse;
import org.example.commandeservice.entity.Commande;
import org.example.commandeservice.entity.LigneCommande;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LigneCommandeMapper {
    private final ModelMapper mapper;

    @Autowired
    public LigneCommandeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public LigneCommandeDtoResponse mapToDto(LigneCommande ligneCommande) {
        return mapper.map(ligneCommande, LigneCommandeDtoResponse.class);
    }

    public LigneCommande mapToEntity(LigneCommandeDtoRequest ligneCommandeDtoRequest) {
        return mapper.map(ligneCommandeDtoRequest, LigneCommande.class);
    }
}
