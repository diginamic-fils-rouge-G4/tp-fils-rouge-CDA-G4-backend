package dev.entite.donneeApiQualiteAir;

public class ApiGeo {
    /**
     * Le nom de la ville
     */
    private String name;
    /**
     * La latitude de la ville
     */
    private float lat;
    /**
     * Le La longitude la ville de la ville
     */
    private float lon;
    /**
     * Le payé de la ville
     */
    private String country;
    /**
     * L'état de la ville
     */
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiGeo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", country='").append(country).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
