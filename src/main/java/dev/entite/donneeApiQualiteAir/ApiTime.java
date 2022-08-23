package dev.entite.donneeApiQualiteAir;

/**
 * Classe pour la définition des temps exact de la mesure des scores des polluantsretourné par l'API
 */
public class ApiTime {
    /**
     * Le temps de la mesure
     */
    private String s;
    // Getter Methods
    public String getS() {
        return s;
    }
    // Setter Methods
    public void setS(String s) {
        this.s = s;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiTime{");
        sb.append("s='").append(s).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
