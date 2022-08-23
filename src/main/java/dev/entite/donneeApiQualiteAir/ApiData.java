package dev.entite.donneeApiQualiteAir;

import java.util.ArrayList;

/**
 * Classe pour la définition la data retourné par l'API
 */
public class ApiData {

    /**
     * Le score aqi de la station
     */
    private float aqi;
    /**
     * L'idx de la station
     */
    private float idx;
    /**
     * La ville de la station
     */
    ApiCity City;
    /**
     * Les scores des polluants de la station
     */
    ApiIaqi Iaqi;
    /**
     * L'heure de pris des polluants de station
     */
    ApiTime Time;

    public float getAqi() {
        return aqi;
    }

    public void setAqi(float aqi) {
        this.aqi = aqi;
    }

    public float getIdx() {
        return idx;
    }

    public void setIdx(float idx) {
        this.idx = idx;
    }

    public ApiCity getCity() {
        return City;
    }

    public void setCity(ApiCity city) {
        City = city;
    }


    public ApiIaqi getIaqi() {
        return Iaqi;
    }

    public void setIaqi(ApiIaqi iaqi) {
        Iaqi = iaqi;
    }

    public ApiTime getTime() {
        return Time;
    }

    public void setTime(ApiTime time) {
        Time = time;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiData{");
        sb.append("aqi=").append(aqi);
        sb.append(", idx=").append(idx);
        sb.append(", City=").append(City);
        sb.append(", Iaqi=").append(Iaqi);
        sb.append(", Time=").append(Time);
        sb.append(", city=").append(getCity());
        sb.append(", iaqi=").append(getIaqi());
        sb.append(", time=").append(getTime());
        sb.append('}');
        return sb.toString();
    }
}
