package dev.entite.donneeApiQualiteAir;


/**
 * Classe pour la définition des réponses retourné par l'API
 */
public class ApiResponse {
    /**
     * Le statut de la requête
     */
    private String status;
    /**
     * La data retournée par la requête
     */
    ApiData DataObject;

    // Getter Methods

    public String getStatus() {
        return status;
    }
    public ApiData getData() {
        return DataObject;
    }
    // Setter Methods
    public void setStatus(String status) {
        this.status = status;
    }
    public void setData(ApiData dataObject) {
        this.DataObject = dataObject;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiResponse{");
        sb.append("status='").append(status).append('\'');
        sb.append(", DataObject=").append(DataObject);
        sb.append(", data=").append(getData());
        sb.append('}');
        return sb.toString();
    }
}



