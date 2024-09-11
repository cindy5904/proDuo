package org.example.livraisonservice.controller;

import org.example.livraisonservice.dto.LivraisonDtoRequest;
import org.example.livraisonservice.dto.LivraisonDtoResponse;
import org.example.livraisonservice.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {
    private final LivraisonService livraisonService;

    @Autowired
    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @PostMapping
    public ResponseEntity<LivraisonDtoResponse> createLivraison(@RequestBody LivraisonDtoRequest livraisonDtoRequest) {
        LivraisonDtoResponse response = livraisonService.createLivraison(livraisonDtoRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivraisonDtoResponse> getLivraisonById(@PathVariable long id) {
        try {
            LivraisonDtoResponse response = livraisonService.getLivraisonById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<LivraisonDtoResponse>> getAllLivraisons() {
        List<LivraisonDtoResponse> responses = livraisonService.getAllLivraisons();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivraisonDtoResponse> updateLivraison(
            @PathVariable long id, @RequestBody LivraisonDtoRequest livraisonDtoRequest) {
        try {
            LivraisonDtoResponse response = livraisonService.updateLivraison(id, livraisonDtoRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivraison(@PathVariable long id) {
        try {
            livraisonService.deleteLivraison(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/commande/{idCommande}")
    public ResponseEntity<List<LivraisonDtoResponse>> getLivraisonsByCommandeId(@PathVariable long idCommande) {
        List<LivraisonDtoResponse> responses = livraisonService.getLivraisonsByCommandeId(idCommande);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
