package dev.service;

import dev.entite.qualite.Polluant;
import dev.repository.PolluantRepository;
import org.springframework.stereotype.Service;

/**
 * Service pour les polluants
 * Voir {@link dev.service.StationService} pour utilisation
 */
@Service
public class PolluantService {
    /**
     * Voir {@link dev.repository.PolluantRepository}
     */
    private PolluantRepository polluantRepository;

    public PolluantService(PolluantRepository polluantRepository) {
        this.polluantRepository = polluantRepository;
    }

    /**
     * Création d'un polluant
     * @param polluant
     * @return le nouveau polluant
     */
    public Polluant createPolluant(Polluant polluant){
        return polluantRepository.save(polluant);
    }
}
