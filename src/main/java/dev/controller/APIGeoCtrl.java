package dev.controller;

import dev.service.APIGeoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *  Controlleur utilisé pour l'API de récupération des données <br/>
 *  @see <a href="https://aqicn.org/json-api/doc/" target="blank">Doc</a> <br/>
 *  <br/>
 *  l'api est utilisé pour récupérer les informations sur les villes <br/>
 *  Utilise le service : {@link dev.service.APIGeoService}
 */
@CrossOrigin
@RestController
@RequestMapping("geo")
public class APIGeoCtrl {

    private APIGeoService apiGeoService;

    public APIGeoCtrl(APIGeoService apiGeoService) {
        this.apiGeoService = apiGeoService;
    }

    /**
     * Récupère une ville selon ses coordonnées géographiques
     * @param lat latitude
     * @param lon longitude
     * @return
     */
    @GetMapping("latlng")
    @ResponseBody
    public ResponseEntity<?> getAllStations(@RequestParam String lat,
                                            @RequestParam String lon) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiGeoService.getCityByGeo(lat, lon));
    }

}
