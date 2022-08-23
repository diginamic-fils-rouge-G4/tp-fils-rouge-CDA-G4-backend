package dev.service;

import dev.entite.qualite.Meteo;
import dev.entite.qualite.Polluant;
import dev.repository.MeteoRepository;
import dev.repository.PolluantRepository;
import org.springframework.stereotype.Service;

/**
 * Service pour les polluants
 * Voir {@link StationService} pour utilisation
 */
@Service
public class MeteoService {
    /**
     * Voir {@link PolluantRepository}
     */
    private MeteoRepository meteoRepository;

    public MeteoService(MeteoRepository meteoRepository) {
        this.meteoRepository = meteoRepository;
    }

    /**
     * Création d'un polluant
     * @param meteo
     * @return le nouveau polluant
     */
    public Meteo createMeteo(Meteo meteo){
        return meteoRepository.save(meteo);
    }
}
