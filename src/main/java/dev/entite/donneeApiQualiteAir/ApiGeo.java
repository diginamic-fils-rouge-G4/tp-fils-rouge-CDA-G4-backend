package dev.entite.donneeApiQualiteAir;

import java.util.ArrayList;
import java.util.List;

public class ApiGeo {
    private String code;
    private String nom;
    List< Object > codesPostaux = new ArrayList< Object >();
    private float population;
    ApiDepartement Departement;
    ApiRegion Region;


    // Getter Methods

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public float getPopulation() {
        return population;
    }

    public List<Object> getCodesPostaux() {
        return codesPostaux;
    }

// Setter Methods

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public void setCodesPostaux(List<Object> codesPostaux) {
        this.codesPostaux = codesPostaux;
    }

    public ApiDepartement getDepartement() {
        return Departement;
    }

    public void setDepartement(ApiDepartement departement) {
        Departement = departement;
    }

    public ApiRegion getRegion() {
        return Region;
    }

    public void setRegion(ApiRegion region) {
        Region = region;
    }
}
