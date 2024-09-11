package org.example.livraisonservice.util;

import org.example.livraisonservice.dto.LivraisonDtoRequest;
import org.example.livraisonservice.dto.LivraisonDtoResponse;
import org.example.livraisonservice.entity.Livraison;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LivraisonMapper {
    private final ModelMapper mapper;

    @Autowired
    public LivraisonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public LivraisonDtoResponse mapToDto(Livraison livraison) {

        return mapper.map(livraison, LivraisonDtoResponse.class);
    }

    public Livraison mapToEntity(LivraisonDtoRequest livraisonDtoRequest) {
        return mapper.map(livraisonDtoRequest, Livraison.class);
    }
}
