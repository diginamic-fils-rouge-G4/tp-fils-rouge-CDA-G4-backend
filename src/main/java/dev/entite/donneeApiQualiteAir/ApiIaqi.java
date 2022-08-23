package dev.entite.donneeApiQualiteAir;

import dev.entite.donneeApiQualiteAir.polluant.*;
/**
 * Classe pour la définition la Score Iaqi  dans le data
 * retourné par l'API
 */
public class ApiIaqi {


    /**
     * Le polluant H
     */
    H H;
    /**
     * Le polluant P
     */
    P P;
    /**
     * Le polluant Pm25
     */
    Pm25 Pm25;
    /**
     * Le polluant T
     */
    T T;
    /**
     * Le polluant W
     */
    W W;
    /**
     * Le polluant Wg
     */
    Wg Wg;



    public dev.entite.donneeApiQualiteAir.polluant.H getH() {
        return H;
    }

    public void setH(dev.entite.donneeApiQualiteAir.polluant.H h) {
        H = h;
    }

    public dev.entite.donneeApiQualiteAir.polluant.P getP() {
        return P;
    }

    public void setP(dev.entite.donneeApiQualiteAir.polluant.P p) {
        P = p;
    }

    public dev.entite.donneeApiQualiteAir.polluant.Pm25 getPm25() {
        return Pm25;
    }

    public void setPm25(dev.entite.donneeApiQualiteAir.polluant.Pm25 pm25) {
        Pm25 = pm25;
    }

    public dev.entite.donneeApiQualiteAir.polluant.T getT() {
        return T;
    }

    public void setT(dev.entite.donneeApiQualiteAir.polluant.T t) {
        T = t;
    }

    public dev.entite.donneeApiQualiteAir.polluant.W getW() {
        return W;
    }

    public void setW(dev.entite.donneeApiQualiteAir.polluant.W w) {
        W = w;
    }

    public dev.entite.donneeApiQualiteAir.polluant.Wg getWg() {
        return Wg;
    }

    public void setWg(dev.entite.donneeApiQualiteAir.polluant.Wg wg) {
        Wg = wg;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ApiIaqi{");
        sb.append("H=").append(H);
        sb.append(", P=").append(P);
        sb.append(", Pm25=").append(Pm25);
        sb.append(", T=").append(T);
        sb.append(", W=").append(W);
        sb.append(", Wg=").append(Wg);
        sb.append(", h=").append(getH());
        sb.append(", p=").append(getP());
        sb.append(", pm25=").append(getPm25());
        sb.append(", t=").append(getT());
        sb.append(", w=").append(getW());
        sb.append(", wg=").append(getWg());
        sb.append('}');
        return sb.toString();
    }
}
