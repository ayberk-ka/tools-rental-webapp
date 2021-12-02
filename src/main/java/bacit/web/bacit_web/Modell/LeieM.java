package bacit.web.bacit_web.Modell;

import java.util.Date;

public class LeieM {
    private int leie_id, ansatt_id, utstyr_id;
    private Date start_leie_dato;
    private Date tilbake_dato;
    private int betalt;
    private float total_kostnad;
    private String tilstandsvurdering;

    public LeieM( int ansatt_id, int utstyr_id, Date start_leie_dato, Date tilbake_dato, int betalt, float total_kostnad, String tilstandsvurdering) {
        this.leie_id = leie_id;
        this.ansatt_id = ansatt_id;
        this.utstyr_id = utstyr_id;
        this.start_leie_dato = start_leie_dato;
        this.tilbake_dato = tilbake_dato;
        this.betalt = betalt;
        this.total_kostnad = total_kostnad;
        this.tilstandsvurdering = tilstandsvurdering;
    }

    public int getLeie_id() {
        return leie_id;
    }

    public void setLeie_id(int leie_id) {
        this.leie_id = leie_id;
    }

    public int getAnsatt_id() {
        return ansatt_id;
    }

    public void setAnsatt_id(int ansatt_id) {
        this.ansatt_id = ansatt_id;
    }

    public int getUtstyr_id() {
        return utstyr_id;
    }

    public void setUtstyr_id(int utstyr_id) {
        this.utstyr_id = utstyr_id;
    }

    public Date getStart_leie_dato() {
        return start_leie_dato;
    }

    public void setStart_leie_dato(Date start_leie_dato) {
        this.start_leie_dato = start_leie_dato;
    }

    public Date getTilbake_dato() {
        return tilbake_dato;
    }

    public void setTilbake_dato(Date tilbake_dato) {
        this.tilbake_dato = tilbake_dato;
    }

    public int getBetalt() {
        return betalt;
    }

    public void setBetalt(int betalt) {
        this.betalt = betalt;
    }

    public float getTotal_kostnad() {
        return total_kostnad;
    }

    public void setTotal_kostnad(float total_kostnad) {
        this.total_kostnad = total_kostnad;
    }

    public String getTilstandsvurdering() {
        return tilstandsvurdering;
    }

    public void setTilstandsvurdering(String tilstandsvurdering) {
        this.tilstandsvurdering = tilstandsvurdering;
    }
}


