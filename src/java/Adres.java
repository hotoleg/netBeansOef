/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oleg.kolokolnikov
 */
public class Adres {
    private String straat;
    private String huisNr;
    private Gemeente gemeente;
    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public void setHuisNr(String huisNr) {
        this.huisNr = huisNr;
    }
    public void setGemeente(Gemeente gemeente) {
        this.gemeente=gemeente;
    }
    public Gemeente getGemeente() {
        return gemeente;
    }
}
