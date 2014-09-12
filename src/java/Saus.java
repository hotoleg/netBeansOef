
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oleg.Kolokolnikov
 */
public class Saus {
    long nummer;
    private String naam;
    private List<String> ingredienten;

    public Saus(long nummer, String naam, List<String> ingredienten) {
        this.nummer = nummer;
        this.naam = naam;
        this.ingredienten = ingredienten;
    }

    public long getNummer() {
        return nummer;
    }

    public void setNummer(long nummer) {
        this.nummer = nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<String> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<String> ingredienten) {
        this.ingredienten = ingredienten;
    }
 
    
}
