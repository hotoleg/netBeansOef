/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import java.util.Calendar;

/**
 *
 * @author oleg.kolokolnikov
 */
public class Begroeting {
    private final String boodschap;
    public Begroeting() {
        Calendar calendar = Calendar.getInstance();
        int dag = calendar.get(Calendar.DAY_OF_WEEK);
        if (dag == Calendar.MONDAY || dag == Calendar.THURSDAY) {
            boodschap = "We zijn gesloten";
        } else {
            boodschap = "We zijn open";
        }
    }
    @Override
    public String toString() {
        return boodschap;
    }
}
