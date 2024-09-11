package org.example.livraisonservice.service;

import org.example.livraisonservice.dto.LivraisonDtoRequest;
import org.example.livraisonservice.dto.LivraisonDtoResponse;
import org.example.livraisonservice.entity.Livraison;
import org.example.livraisonservice.repository.LivraisonRepository;
import org.example.livraisonservice.util.LivraisonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivraisonService {
    private final LivraisonRepository livraisonRepository;
    private final LivraisonMapper livraisonMapper;

    @Autowired
    public LivraisonService(LivraisonRepository livraisonRepository, LivraisonMapper livraisonMapper) {
        this.livraisonRepository = livraisonRepository;
        this.livraisonMapper = livraisonMapper;
    }

    public LivraisonDtoResponse createLivraison(LivraisonDtoRequest livraisonDtoRequest) {
        Livraison livraison = livraisonMapper.mapToEntity(livraisonDtoRequest);
        Livraison savedLivraison = livraisonRepository.save(livraison);
        return livraisonMapper.mapToDto(savedLivraison);
    }

    public LivraisonDtoResponse getLivraisonById(long id) {
        Optional<Livraison> livraison = livraisonRepository.findById(id);
        if (livraison.isPresent()) {
            return livraisonMapper.mapToDto(livraison.get());
        } else {
            throw new RuntimeException("Livraison non trouvée avec l'ID : " + id);
        }
    }

    public List<LivraisonDtoResponse> getAllLivraisons() {
        List<Livraison> livraisons = (List<Livraison>) livraisonRepository.findAll();
        return livraisons.stream()
                .map(livraisonMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public LivraisonDtoResponse updateLivraison(long id, LivraisonDtoRequest livraisonDtoRequest) {
        Optional<Livraison> existingLivraison = livraisonRepository.findById(id);
        if (existingLivraison.isPresent()) {
            Livraison livraisonToUpdate = existingLivraison.get();
            livraisonToUpdate.setId_commande(livraisonDtoRequest.getId_commande());
            livraisonToUpdate.setEtat(livraisonDtoRequest.getEtat());
            livraisonToUpdate.setDate(livraisonDtoRequest.getDate());
            livraisonToUpdate.setType(livraisonDtoRequest.getType());

            Livraison updatedLivraison = livraisonRepository.save(livraisonToUpdate);
            return livraisonMapper.mapToDto(updatedLivraison);
        } else {
            throw new RuntimeException("Livraison non trouvée avec l'ID : " + id);
        }
    }

    public void deleteLivraison(long id) {
        if (livraisonRepository.existsById(id)) {
            livraisonRepository.deleteById(id);
        } else {
            throw new RuntimeException("Livraison non trouvée avec l'ID : " + id);
        }
    }


    public List<LivraisonDtoResponse> getLivraisonsByCommandeId(long idCommande) {
        List<Livraison> livraisons = livraisonRepository.findLivraisonsByCommandeId(idCommande);
        return livraisons.stream()
                .map(livraisonMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
