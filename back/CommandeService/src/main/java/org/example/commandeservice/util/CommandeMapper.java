package org.example.commandeservice.util;

import org.example.commandeservice.dto.CommandeDto.CommandeDtoRequest;
import org.example.commandeservice.dto.CommandeDto.CommandeDtoResponse;
import org.example.commandeservice.entity.Commande;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {
    private final ModelMapper mapper;

    @Autowired
    public CommandeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public CommandeDtoResponse mapToDto(Commande commande) {
        return mapper.map(commande, CommandeDtoResponse.class);
    }


    public Commande mapToEntity(CommandeDtoRequest commandeDtoRequest) {
        return mapper.map(commandeDtoRequest, Commande.class);
    }
}
