package dev.service;

import dev.entite.lieu.Region;
import dev.repository.RegionRepository;
import org.springframework.stereotype.Service;

@Service
public class RegionService {
    private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public Region getByName(String name) {
        return regionRepository.findByNom(name);
    }

    public Region create(Region region) {
        return regionRepository.save(region);
    }
}
