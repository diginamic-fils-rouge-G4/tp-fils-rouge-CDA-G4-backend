package dev.controller.dto.station;

import dev.entite.lieu.Ville;
import dev.entite.qualite.Polluant;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 *  DTO utilisé pour la création de "Station"
 */
public class StationDTO {

    /**
     * idx de la station <br/>
     * L'idx des stations est une id unique utilisé par l'api de qualité de l'air
     */
    private String idx;
    /**
     * Nom de la station
     */
    private String nom;

    // Constructor
    public StationDTO() {
    }

    // Getter & Setter
    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
