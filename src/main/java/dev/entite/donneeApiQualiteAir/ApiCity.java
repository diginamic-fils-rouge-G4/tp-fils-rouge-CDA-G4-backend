package dev.entite.donneeApiQualiteAir;

import java.util.ArrayList;

/**
 * Classe pour la définition la Ville dans le data
 * retourné par l'API
 */
public class ApiCity {

    /**
     * Les coordonnées géographiques de la ville
     */
    ArrayList< Object > geo = new ArrayList < Object > ();
    /**
     * Le nom de la ville
     */
    private String name;
    /**
     * L'URL de la ville
     */
    private String url;
    /**
     * La location de la ville
     */
    private String location;


    // Getter Methods

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return location;
    }

    // Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Object> getGeo() {
        return geo;
    }

    public void setGeo(ArrayList<Object> geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiCity{");
        sb.append("geo=").append(geo);
        sb.append(", name='").append(name).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
