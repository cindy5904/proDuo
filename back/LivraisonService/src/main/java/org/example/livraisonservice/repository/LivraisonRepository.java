package org.example.livraisonservice.repository;

import org.example.livraisonservice.entity.Livraison;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivraisonRepository extends CrudRepository<Livraison, Long> {
    @Query("SELECT l FROM Livraison l WHERE l.id_commande = :idCommande")
    List<Livraison> findLivraisonsByCommandeId(@Param("idCommande") long idCommande);

}
