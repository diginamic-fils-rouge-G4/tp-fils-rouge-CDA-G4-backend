package dev.service;

import dev.entite.donneeApiQualiteAir.ApiResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service pour l'API de qualité d'air
 */
@Service
public class APIQualiteAirService {

    private RestTemplate restTemplate;
    private final String token_api = "dbbd6bd16593d05023748919d281d871c3f79a33";

    public APIQualiteAirService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     * Récupère le feed d'une ville en fonction de son nom
     * @param city String
     * @return String
     */
    public String getFeedCityByName(String city) {
        String url = "https://api.waqi.info/feed/" + city + "/?token=" + this.token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    /**
     * Récupère toutes les stations entre deux points de coordonnées
     * @param lat1 String : latitude première coordonnée
     * @param lng1 String : longitude première coordonnée
     * @param lat2 String : latitude deuxième coordonnée
     * @param lng2 String : longitude deuxième coordonnée
     * @return String
     */
    public String getAllStations(String lat1, String lng1, String lat2, String lng2) {
        String url = "https://api.waqi.info/map/bounds?latlng=" +
                lat1 + "," + lng1 + "," +
                lat2 + "," + lng2 + "&networks=all&token=" + this.token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    /**
     * Récupère la station sur un point de coordonnée précis
     * @param lat String : latitude de la coordonnée voulue
     * @param lng String : longitude de la coordonnée voulue
     * @return String
     */
    public String getMarkerByClick(String lat, String lng) {
        String url = "https://api.waqi.info/feed/geo:" + lat + ";" + lng + "/?token=" + this.token_api;
        return this.restTemplate.getForObject(url, String.class);
    }

    /**
     * Récupère une station grace à son nom
     * @param station String : nom de la station
     * @return JSONObject
     */
    public JSONObject getStationByName(String station) {
        String url = "https://api.waqi.info/search/?keyword=" + station + "&token=" + this.token_api;
        return this.restTemplate.getForObject(url, JSONObject.class);
    }

    /**
     * Récupère une station en JSONObjet par rapport à son id
     * @param id String : id de la station
     * @return JSONObject
     */
    public JSONObject getStationByIdGetJSONObject(String id) {
        String url = "https://api.waqi.info/feed/@" + id + "/?token=" + this.token_api;
        return this.restTemplate.getForObject(url, JSONObject.class);
    }

    /**
     * Récupère une station par rapport à son id
     * @param id String : id de la station
     * @return ApiResponse
     */
    public ApiResponse getStationById(String id) {
        String url = "https://api.waqi.info/feed/@" + id + "/?token=" + this.token_api;
        return this.restTemplate.getForObject(url, ApiResponse.class);
    }

}
