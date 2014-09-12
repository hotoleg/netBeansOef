/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.entities;

import java.math.BigDecimal;

/**
 *
 * @author oleg.kolokolnikov
 */
public class Pizza {
    private long nummer;
    private String naam;
    private BigDecimal prijs;
    private boolean pikant;
    
    public Pizza(long nummer, String naam, BigDecimal prijs, boolean pikant) {
        setNummer(nummer);
        setNaam(naam);
        setPrijs(prijs);
        setPikant(pikant);
    }

    
    /**
     * @return the nummer
     */
    public long getNummer() {
        return nummer;
    }

    /**
     * @param nummer the nummer to set
     */
    public void setNummer(long nummer) {
        this.nummer = nummer;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the prijs
     */
    public BigDecimal getPrijs() {
        return prijs;
    }

    /**
     * @param prijs the prijs to set
     */
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    /**
     * @return the pikant
     */
    public boolean isPikant() {
        return pikant;
    }

    /**
     * @param pikant the pikant to set
     */
    public void setPikant(boolean pikant) {
        this.pikant = pikant;
    }
}
