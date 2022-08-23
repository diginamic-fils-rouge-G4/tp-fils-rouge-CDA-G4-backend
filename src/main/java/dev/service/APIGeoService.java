package dev.service;

import dev.entite.donneeApiQualiteAir.ApiGeo;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class APIGeoService {

    private RestTemplate restTemplate;

    public APIGeoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<ApiGeo[]>  getCityByGeo(String lat , String lon) {
        String url = "https://geo.api.gouv.fr/communes?lat="+lat+"&lon="+lon+"&fields=code,nom,codesPostaux,population,departement,region";

        /*this.restTemplate.getForObject(url, JSONArray.class);*/
        return restTemplate.getForEntity( url, ApiGeo[].class);
    }

}
