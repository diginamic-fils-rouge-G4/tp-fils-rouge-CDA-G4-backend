package dev.entite.qualite;

import dev.entite.BaseEntite;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
     * La pression des données météo
     */
    private String P;
    /**
     * La pression des données météo
     */
    private String H;
    /**
     * La pression des données météo
     */
    private String T;
    /**
     * La pression des données météo
     */
    private String W;
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
    @ManyToOne
    private Station station ;

    // Constructeur
    public Meteo() {
    }

    // Getter & Setter


    public String getP() {
        return P;
    }

    public void setP(String p) {
        P = p;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

    public String getT() {
        return T;
    }

    public void setT(String t) {
        T = t;
    }

    public String getW() {
        return W;
    }

    public void setW(String w) {
        W = w;
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

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
