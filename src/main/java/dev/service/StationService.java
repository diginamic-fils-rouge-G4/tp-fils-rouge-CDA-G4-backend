package dev.service;

import dev.controller.dto.station.StationDTO;
import dev.controller.dto.ville.VilleDTO;
import dev.entite.Utilisateur;
import dev.entite.donneeApiQualiteAir.ApiGeo;
import dev.entite.donneeApiQualiteAir.ApiResponse;
import dev.entite.lieu.Departement;
import dev.entite.lieu.Region;
import dev.entite.lieu.Station;
import dev.entite.lieu.Ville;
import dev.entite.qualite.Meteo;
import dev.entite.qualite.Polluant;
import dev.repository.StationRepository;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Service pour les Stations
 */
@Service
public class StationService {

    private StationRepository stationRepository;
    private VilleService villeService;
    private DepartementService departementService;
    private RegionService regionService;
    private MeteoService meteoService;
    private UtilisateurService utilisateurService;
    private APIGeoService apiGeoService;
    private APIQualiteAirService apiQualiteAirService;
    private PolluantService polluantService;

    public StationService(StationRepository stationRepository, VilleService villeService, DepartementService departementService, RegionService regionService, MeteoService meteoService, UtilisateurService utilisateurService, APIGeoService apiGeoService, APIQualiteAirService apiQualiteAirService, PolluantService polluantService) {
        this.stationRepository = stationRepository;
        this.villeService = villeService;
        this.departementService = departementService;
        this.regionService = regionService;
        this.meteoService = meteoService;
        this.utilisateurService = utilisateurService;
        this.apiGeoService = apiGeoService;
        this.apiQualiteAirService = apiQualiteAirService;
        this.polluantService = polluantService;
    }

    public Station obtenirStationParNom (String nom){
        return stationRepository.findByNom(nom);
    }

    public Station createStation (Station station){
        return stationRepository.save(station);
    }
    public Station obtenirStationParIDX (String idx){
        return stationRepository.findByIdx(idx);
    }

    @Transactional
    public void GetStationStats(String id){

        ApiResponse data = apiQualiteAirService.getStationById(id);

        Station station =obtenirStationParIDX(String.valueOf(Math.round(data.getData().getIdx())));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Meteo meteo = new Meteo();
        if (data.getData().getIaqi().getH() != null){
            meteo.setH(String.valueOf(data.getData().getIaqi().getH().getV()));
        }
        if (data.getData().getIaqi().getP() != null){
            meteo.setP(String.valueOf(data.getData().getIaqi().getP().getV()));
        }
        if (data.getData().getIaqi().getT() != null){
            meteo.setT(String.valueOf(data.getData().getIaqi().getT().getV()));
        }
        if (data.getData().getIaqi().getW() != null){
            meteo.setW(String.valueOf(data.getData().getIaqi().getW().getV()));
        }

        meteo.setDate(LocalDate.from(LocalDateTime.parse(data.getData().getTime().getS() , formatter)));
        meteo.setHeure(LocalTime.from(LocalDateTime.parse(data.getData().getTime().getS() , formatter)));

        station.getMeteos().add(meteo);
        meteo.setStation(station);
        meteoService.createMeteo(meteo);

        if (data.getData().getIaqi().getPm25() != null){
            Polluant Pm25 = new Polluant();
            Pm25.setType("Pm25");
            Pm25.setQualite(String.valueOf(data.getData().getIaqi().getPm25().getV()));
            Pm25.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
            station.getPolluants().add(Pm25);
        }
        if (data.getData().getIaqi().getPm10() != null){
            Polluant Pm10 = new Polluant();
            Pm10.setType("Pm10");
            Pm10.setQualite(String.valueOf(data.getData().getIaqi().getPm10().getV()));
            Pm10.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
            station.getPolluants().add(Pm10);
        }
        if (data.getData().getIaqi().getSO2() != null){
            Polluant SO2 = new Polluant();
            SO2.setType("SO2");
            SO2.setQualite(String.valueOf(data.getData().getIaqi().getSO2().getV()));
            SO2.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
            station.getPolluants().add(SO2);
        }
        if (data.getData().getIaqi().getNo2() != null){
            Polluant No2 = new Polluant();
            No2.setType("No2");
            No2.setQualite(String.valueOf(data.getData().getIaqi().getNo2().getV()));
            No2.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
            station.getPolluants().add(No2);
        }
        if (data.getData().getIaqi().getO3() != null){
            Polluant O3 = new Polluant();
            O3.setType("O3");
            O3.setQualite(String.valueOf(data.getData().getIaqi().getO3().getV()));
            O3.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
            station.getPolluants().add(O3);
        }

        for (Polluant polluant : station.getPolluants()) {
            polluantService.createPolluant(polluant);
        }


    }

    @Transactional
    public Station ajouterStationEnFavoris(String id){

        //We have to check if this station exists in the database, if it exists then we just add this station to the Users Favorites.
        //If not, we have to create the station.
        //While creating the station, we have to check if the city exists in the database, if it exists, then we just add the station to the city.
        //If not, we have to create the city.

        ApiResponse data = apiQualiteAirService.getStationById(id);

        Station station =obtenirStationParIDX(String.valueOf(Math.round(data.getData().getIdx())));

        if (station == null){

            station = new Station();
            station.setIdx(String.valueOf(Math.round(data.getData().getIdx())) );
            station.setNom(data.getData().getCity().getName());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            ResponseEntity<ApiGeo[]> ListVille = apiGeoService.getCityByGeo(data.getData().getCity().getGeo().get(0).toString(), data.getData().getCity().getGeo().get(1).toString());

            Meteo meteo = new Meteo();
            if (data.getData().getIaqi().getH() != null){
                meteo.setH(String.valueOf(data.getData().getIaqi().getH().getV()));
            }
            if (data.getData().getIaqi().getP() != null){
                meteo.setP(String.valueOf(data.getData().getIaqi().getP().getV()));
            }
            if (data.getData().getIaqi().getT() != null){
                meteo.setT(String.valueOf(data.getData().getIaqi().getT().getV()));
            }
            if (data.getData().getIaqi().getW() != null){
                meteo.setW(String.valueOf(data.getData().getIaqi().getW().getV()));
            }

            meteo.setDate(LocalDate.from(LocalDateTime.parse(data.getData().getTime().getS() , formatter)));
            meteo.setHeure(LocalTime.from(LocalDateTime.parse(data.getData().getTime().getS() , formatter)));

            station.getMeteos().add(meteo);
            meteo.setStation(station);
            meteoService.createMeteo(meteo);

            if (data.getData().getIaqi().getPm25() != null){
                Polluant Pm25 = new Polluant();
                Pm25.setType("Pm25");
                Pm25.setQualite(String.valueOf(data.getData().getIaqi().getPm25().getV()));
                Pm25.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
                station.getPolluants().add(Pm25);
            }
            if (data.getData().getIaqi().getPm10() != null){
                Polluant Pm10 = new Polluant();
                Pm10.setType("Pm10");
                Pm10.setQualite(String.valueOf(data.getData().getIaqi().getPm10().getV()));
                Pm10.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
                station.getPolluants().add(Pm10);
            }
            if (data.getData().getIaqi().getSO2() != null){
                Polluant SO2 = new Polluant();
                SO2.setType("SO2");
                SO2.setQualite(String.valueOf(data.getData().getIaqi().getSO2().getV()));
                SO2.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
                station.getPolluants().add(SO2);
            }
            if (data.getData().getIaqi().getNo2() != null){
                Polluant No2 = new Polluant();
                No2.setType("No2");
                No2.setQualite(String.valueOf(data.getData().getIaqi().getNo2().getV()));
                No2.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
                station.getPolluants().add(No2);
            }
            if (data.getData().getIaqi().getO3() != null){
                Polluant O3 = new Polluant();
                O3.setType("O3");
                O3.setQualite(String.valueOf(data.getData().getIaqi().getO3().getV()));
                O3.setDate(LocalDateTime.parse(data.getData().getTime().getS() , formatter));
                station.getPolluants().add(O3);
            }

            for (Polluant polluant : station.getPolluants()) {
                polluantService.createPolluant(polluant);
            }

            this.createStation(station);

            System.out.println(ListVille);


            Ville ville = villeService.obtenirVilleParNom(ListVille.getBody()[0].getNom());

            System.out.println(ville);

            if (ville == null){
                ville = new Ville();
                ville.getStations().add(station);
                ville.setPopulation(0);
                ville.setNom(ListVille.getBody()[0].getNom());
                ville.setCodePostal(ListVille.getBody()[0].getCodesPostaux().get(0).toString());
                Departement departement = departementService.obtenirDepartementParNom(ListVille.getBody()[0].getDepartement().getNom());
                if (departement == null){
                    departement = new Departement();
                    departement.setNom(ListVille.getBody()[0].getDepartement().getNom());
                    departement.setCode(ListVille.getBody()[0].getDepartement().getCode());
                    ville.setDepartement(departement);
                    departement.getVilles().add(ville);
                    Region region = regionService.getByName(ListVille.getBody()[0].getRegion().getNom());
                    if (region == null){
                        region = new Region();
                        region.setNom(ListVille.getBody()[0].getRegion().getNom());
                        departement.setRegion(region);
                        region.getDepartements().add(departement);
                        regionService.create(region);
                    }else {
                        if (!region.getDepartements().contains(departement)){
                            departement.setRegion(region);
                            region.getDepartements().add(departement);
                        }
                    }
                    departementService.create(departement);
                }else {
                    ville.setDepartement(departement);
                    departement.getVilles().add(ville);
                }
                villeService.createVille(ville);
                ville.getStations().add(station);
                station.setVille(ville);
                return station;
            }else {
                if (!ville.getStations().contains(station)){
                    ville.getStations().add(station);
                    station.setVille(ville);
                }
                return station;
            }
        }else {
            return station;
        }
    }
    @Transactional
    public List<StationDTO> addStationUtilisateur(String id){
        Station station = this.ajouterStationEnFavoris(id);
        Utilisateur utilisateur = utilisateurService.getByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()).get();
        if (!utilisateur.getStations().contains(station)){
            utilisateur.getStations().add(station);
            if (!station.getUtilisateurs().contains(utilisateur)){
                station.getUtilisateurs().add(utilisateur);
            }
        }
        List<StationDTO> stationDTOList = new ArrayList<>();
        for (Station utilisateurStation : utilisateur.getStations()) {
            StationDTO stationDTO = new StationDTO();
            stationDTO.setNom(utilisateurStation.getNom());
            stationDTO.setIdx(utilisateurStation.getIdx());
            stationDTOList.add(stationDTO);
        }
        return stationDTOList;
    }

    @Transactional
    public List<VilleDTO> getStationUtilisateur(){
        Utilisateur utilisateur = utilisateurService.getByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()).get();
        List<VilleDTO> list = new ArrayList<>();
        for (Station station : utilisateur.getStations()) {
            VilleDTO villeDTO = new VilleDTO();
            villeDTO.setName(station.getVille().getNom());
            if (list.contains(villeDTO)){

                StationDTO stationDTO = new StationDTO();
                stationDTO.setNom(station.getNom());
                stationDTO.setIdx(station.getIdx());
                villeDTO.getStations().add(stationDTO);
            }else {
                list.add(villeDTO);
                StationDTO stationDTO = new StationDTO();
                stationDTO.setNom(station.getNom());
                stationDTO.setIdx(station.getIdx());
                villeDTO.getStations().add(stationDTO);
            }
        }
        return list;
    }

    @Transactional
    public Station getStationUtilisateurById(String id){
        return stationRepository.findByIdxAAndUtilisateurEmail(id,SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
    }

    @Transactional
    public List<Station> deleteStationUtilisateur(String id){
        Station station = this.ajouterStationEnFavoris(id);
        Utilisateur utilisateur = utilisateurService.getByMail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()).get();
        utilisateur.getStations().remove(station);
        return utilisateur.getStations();
    }
}
