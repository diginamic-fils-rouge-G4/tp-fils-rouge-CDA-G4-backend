package dev.service;

import dev.entite.lieu.Departement;
import dev.entite.lieu.Station;
import dev.repository.DepartementRepository;
import org.springframework.stereotype.Service;

/**
 * Service pour les départements
 */
@Service
public class DepartementService {

    private DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    /**
     * Récupère un département avec son nom
     * @param nom
     * @return
     */
    public Departement obtenirDepartementParNom (String nom){
        return departementRepository.findByNom(nom);
    }

    /**
     * Créé un département
     * @param departement
     * @return
     */
    public Departement create(Departement departement) {
            return departementRepository.save(departement);
    }

}
