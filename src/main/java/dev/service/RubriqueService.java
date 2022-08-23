package dev.service;

import dev.controller.dto.rubrique.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.repository.RubriqueRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Service pour les Rubriques
 */
@Service
public class RubriqueService {
    private RubriqueRepository rubriqueRepository;

    public RubriqueService(RubriqueRepository rubriqueRepository) {
        this.rubriqueRepository = rubriqueRepository;
    }

    public Rubrique create(@Valid RubriqueDTO rubriqueDTO) {
        Rubrique rubrique = new Rubrique();
        rubrique.setLibelle(rubriqueDTO.getLibelle());
        return rubriqueRepository.save(rubrique);
    }

    /**
     * Récupère la totalité des Rubriques
     * @return
     */
    public List<Rubrique> findAll() {
        return rubriqueRepository.findAll();
    }

    /**
     * Récupère une Rubrique graces à son libelle
     * @param libelle
     * @return
     */
    public Optional<Rubrique> findByLibelle(String libelle) {
        return rubriqueRepository.findByLibelle(libelle);
    }

    /**
     * Récupère une Rubrique grâce à son id
     * @param id
     * @return
     */
    public Optional<Rubrique> getByid(Integer id){
        return rubriqueRepository.findById(id);
    }

    /**
     * Supprime une rubrique
     * @param rubrique
     */
    public void deleteRubrique(Rubrique rubrique) {
        rubriqueRepository.delete(rubrique);
    }

    /**
     * Enregistre une rubrique
     * @param rubrique
     * @return
     */
    public Rubrique saveRubrique(Rubrique rubrique) {
        return  rubriqueRepository.save(rubrique);
    }
}
