package org.example.commandeservice.service;

import org.example.commandeservice.dto.CommandeDto.CommandeDtoRequest;
import org.example.commandeservice.dto.CommandeDto.CommandeDtoResponse;
import org.example.commandeservice.entity.Commande;
import org.example.commandeservice.entity.LigneCommande;
import org.example.commandeservice.repository.CommandeRepository;
import org.example.commandeservice.repository.LigneCommandeRepository;
import org.example.commandeservice.util.CommandeMapper;
import org.example.commandeservice.util.LigneCommandeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final LigneCommandeRepository ligneCommandeRepository;
    private final CommandeMapper commandeMapper;
    private final LigneCommandeMapper ligneCommandeMapper;

    @Autowired
    public CommandeService(
            CommandeRepository commandeRepository,
            LigneCommandeRepository ligneCommandeRepository,
            CommandeMapper commandeMapper,
            LigneCommandeMapper ligneCommandeMapper
    ) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.commandeMapper = commandeMapper;
        this.ligneCommandeMapper = ligneCommandeMapper;
    }

    public CommandeDtoResponse createCommande(CommandeDtoRequest commandeDtoRequest) {
        Commande commande = commandeMapper.mapToEntity(commandeDtoRequest);


        Set<LigneCommande> lignesCommande = commandeDtoRequest.getLignesCommande().stream()
                .map(ligneCommandeMapper::mapToEntity)
                .peek(ligneCommande -> ligneCommande.setCommande(commande))
                .collect(Collectors.toSet());
        commande.setLignesCommande(lignesCommande);

        Commande savedCommande = commandeRepository.save(commande);
        return commandeMapper.mapToDto(savedCommande);
    }

    public CommandeDtoResponse getCommandeById(long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        if (commande.isPresent()) {
            return commandeMapper.mapToDto(commande.get());
        } else {
            throw new RuntimeException("Commande non trouvée avec l'ID : " + id);
        }
    }

    public List<CommandeDtoResponse> getAllCommandes() {
        List<Commande> commandes = (List<Commande>) commandeRepository.findAll();
        return commandes.stream()
                .map(commandeMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public CommandeDtoResponse updateCommande(long id, CommandeDtoRequest commandeDtoRequest) {
        Optional<Commande> existingCommande = commandeRepository.findById(id);
        if (existingCommande.isPresent()) {
            Commande commandeToUpdate = existingCommande.get();
            commandeToUpdate.setIdUser(commandeDtoRequest.getIdUser());
            commandeToUpdate.setDate(commandeDtoRequest.getDate());
            commandeToUpdate.setStatut(commandeDtoRequest.getStatut());


            Set<LigneCommande> lignesCommande = commandeDtoRequest.getLignesCommande().stream()
                    .map(ligneCommandeMapper::mapToEntity)
                    .peek(ligneCommande -> ligneCommande.setCommande(commandeToUpdate))
                    .collect(Collectors.toSet());
            commandeToUpdate.setLignesCommande(lignesCommande);

            Commande updatedCommande = commandeRepository.save(commandeToUpdate);
            return commandeMapper.mapToDto(updatedCommande);
        } else {
            throw new RuntimeException("Commande non trouvée avec l'ID : " + id);
        }
    }

    public void deleteCommande(long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commande non trouvée avec l'ID : " + id);
        }
    }
}
