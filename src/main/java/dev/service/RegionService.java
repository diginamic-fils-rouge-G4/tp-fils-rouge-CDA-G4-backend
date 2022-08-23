package dev.service;

import dev.entite.lieu.Region;
import dev.repository.RegionRepository;
import org.springframework.stereotype.Service;

/**
 * Service pour les régions
 */
@Service
public class RegionService {
    private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * Récupère une région avec son nom
     * @param name
     * @return
     */
    public Region getByName(String name) {
        return regionRepository.findByNom(name);
    }

    /**
     * Créé une region
     * @param region
     * @return
     */
    public Region create(Region region) {
        return regionRepository.save(region);
    }
}
