package org.example.commandeservice.controller;

import org.example.commandeservice.dto.CommandeDto.CommandeDtoRequest;
import org.example.commandeservice.dto.CommandeDto.CommandeDtoResponse;
import org.example.commandeservice.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    private final CommandeService commandeService;

    @Autowired
    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @PostMapping
    public ResponseEntity<CommandeDtoResponse> createCommande(@RequestBody CommandeDtoRequest commandeDtoRequest) {
        try {
            CommandeDtoResponse response = commandeService.createCommande(commandeDtoRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeDtoResponse> getCommandeById(@PathVariable long id) {
        try {
            CommandeDtoResponse response = commandeService.getCommandeById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<CommandeDtoResponse>> getAllCommandes() {
        List<CommandeDtoResponse> responses = commandeService.getAllCommandes();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeDtoResponse> updateCommande(
            @PathVariable long id, @RequestBody CommandeDtoRequest commandeDtoRequest) {
        try {
            CommandeDtoResponse response = commandeService.updateCommande(id, commandeDtoRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable long id) {
        try {
            commandeService.deleteCommande(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
