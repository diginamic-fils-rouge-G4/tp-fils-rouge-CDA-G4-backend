package dev.entite.qualite;

import dev.entite.BaseEntite;
import dev.entite.lieu.Ville;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe pour la définition des données météo <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Meteo extends BaseEntite {
    /**
     * La mesure des données météo
     */
    private String mesure;
    /**
     * La date des données météo
     */
    private LocalDate date;
    /**
     * L'heure des données météo
     */
    private LocalTime heure;
    /**
     * Relation many to many avec les villes <br/>
     * Jointure bdd = meteo_villes <br/>
     * Voir {@link dev.entite.lieu.Ville}
     */
    @ManyToMany
    private List<Ville> villes = new ArrayList<>();

    // Constructeur
    public Meteo() {
    }

    // Getter & Setter
    public String getMesure() {
        return mesure;
    }

    public void setMesure(String mesure) {
        this.mesure = mesure;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }
}
