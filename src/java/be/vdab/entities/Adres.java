/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

/**
 *
 * @author oleg.kolokolnikov
 */
public class Adres {
    private String straat;
    private String huisNr;
    private String postCode;
    private String gemeente;
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
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
    this.postCode = postCode;
    }
    public String getGemeente() {
        return gemeente;
    }
    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

}