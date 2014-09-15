/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

import be.vdab.entities.Pizza;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author oleg.kolokolnikov
 */
public class PizzaDAO {
    private static final Map<Long, Pizza> pizzas =new ConcurrentHashMap<Long, Pizza>(); 
    static {
        pizzas.put(12L, new Pizza(12L,"Prosciutto",new BigDecimal(4),true));
        pizzas.put(14L, new Pizza(14L,"Margehrita",new BigDecimal(5),false));
        pizzas.put(17L, new Pizza(17L,"Calzone",new BigDecimal(4),false));
        pizzas.put(23L, new Pizza(23L,"Fungi & Olive",new BigDecimal(5),false));
    }
    public List<Pizza> findAll() { 
        return new ArrayList<Pizza>(pizzas.values());
    }
    public Pizza read(long nummer) {
        return pizzas.get(nummer);
    }
    public List<Pizza> findByPrijs(BigDecimal van, BigDecimal tot) {
        List<Pizza> resultaat = new ArrayList<Pizza>();
        for (Pizza pizza : pizzas.values()) {
            if (pizza.getPrijs().compareTo(van) >= 0
                && pizza.getPrijs().compareTo(tot) <= 0) {
                resultaat.add(pizza);
            }
        }
        return resultaat;
    }
    public void create(Pizza pizza) {
        long hoogsteNummer = Collections.max(pizzas.keySet());
        pizza.setNummer(hoogsteNummer + 1);
        pizzas.put(pizza.getNummer(), pizza);
    }   
}
