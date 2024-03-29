package dev.controller.dto.ville;

import dev.controller.dto.station.StationDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *  DTO utilisé pour la création de "Ville"
 */
public class VilleDTO {
    /**
     * Nom de la ville
     */
    private String name;
    /**
     * Liste des stations présente dans la ville
     */
    private List<StationDTO> stations = new ArrayList<>();

    // Constructor
    public VilleDTO() {
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StationDTO> getStations() {
        return stations;
    }

    public void setStations(List<StationDTO> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VilleDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", stations=").append(stations);
        sb.append('}');
        return sb.toString();
    }
}
