package dev.controller.dto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;

public class TopicModifDTO {
    @NotBlank
    private Integer id;
    @NotBlank
    private Integer rubrique;
    @NotBlank
    private String libelle;
    @NotBlank
    private Integer utilisateur;

    public TopicModifDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRubrique() {
        return rubrique;
    }

    public void setRubrique(Integer rubrique) {
        this.rubrique = rubrique;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Integer utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "topicModifDTO{" +
                "id=" + id +
                ", rubrique_id=" + rubrique +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
