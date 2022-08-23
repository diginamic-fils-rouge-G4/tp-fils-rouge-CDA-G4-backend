package dev.controller;

import dev.entite.forum.Rubrique;
import dev.service.APIQualiteAirService;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  Controlleur utilisé pour appeler les requêtes de l'api sur la qualité de l'air <br/>
 *  Utilise le service : {@link dev.service.APIQualiteAirService}
 */
@CrossOrigin
@RestController
@RequestMapping("api")
public class APIQualiteAirCtrl {

    private APIQualiteAirService apiQualiteAirService;

    public APIQualiteAirCtrl(APIQualiteAirService apiQualiteAirService) {
        this.apiQualiteAirService = apiQualiteAirService;
    }

    /**
     * Récupère les informations de qualité de l'air d'une ville selon le nom de celle-ci
     * @param nom nom de la ville
     * @return les datas de l'api
     */
    @GetMapping("ville/{nom}")
    @ResponseBody
    public ResponseEntity<?> getFeedCityByName(@PathVariable String nom) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiQualiteAirService.getFeedCityByName(nom));
    }

    /**
     * Récupère toutes les stations et leurs informations de qualité de l'air en fonction <br/>
     * de deux ensembles de coordonnées géographiques
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return toute les stations correspondante
     */
    @GetMapping("latlng")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public ResponseEntity<?> getAllStations(@RequestParam String lat1,
                                 @RequestParam String lng1,
                                 @RequestParam String lat2,
                                 @RequestParam String lng2) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiQualiteAirService.getAllStations(lat1, lng1, lat2, lng2));
    }

    /**
     * Récupère une station et ses informations sur la qualité de l'air à l'aide de ses coordonnées géographiques.<br/>
     * Cette méthode est utilisée lorsque l'on click sur un marqueur représentant une station<br/>
     * @param lat
     * @param lng
     * @return une station et ses informations sur la qualité de l'air
     */
    @GetMapping("markerClick")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public ResponseEntity<?> getMarkerByClick(@RequestParam String lat,
                                   @RequestParam String lng) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiQualiteAirService.getMarkerByClick(lat, lng));
    }

    /**
     * Récupère une station et ses informations sur la qualité de l'air à l'aide de son nom
     * @param station nom de la station
     * @return une station et ses informations sur la qualité de l'air
     */
    @GetMapping("station/{station}")
    @ResponseBody
    // A FAIRE. Utilisé un ResponseEntity
    public ResponseEntity<?> getStationByName(@PathVariable String station) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiQualiteAirService.getStationByName(station));
    }

}
