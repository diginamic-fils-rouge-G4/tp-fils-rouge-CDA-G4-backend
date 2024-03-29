package dev.repository;

import dev.entite.qualite.Meteo;
import dev.entite.qualite.Polluant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface pour les méthodes en lien avec la table polluant
 */
@Repository
public interface MeteoRepository extends JpaRepository<Meteo, Integer> {
}
