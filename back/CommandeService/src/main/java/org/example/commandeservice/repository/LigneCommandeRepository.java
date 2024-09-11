package org.example.commandeservice.repository;

import org.example.commandeservice.entity.LigneCommande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Long> {
    List<LigneCommande> findByCommandeId(long commandeId);
}
