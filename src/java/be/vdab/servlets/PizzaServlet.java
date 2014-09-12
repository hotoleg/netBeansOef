/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import be.vdab.util.RequestStatistiek;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@WebServlet("/pizzas")
public class PizzaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";
private final RequestStatistiek requestStatistiek = new RequestStatistiek();
private final PizzaDAO pizzaDAO = new PizzaDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pizza> pizzas = Arrays.asList(
        new Pizza(12L, "Prosciutto", new BigDecimal(4), true),
        new Pizza(14L, "Margehrita", new BigDecimal(5), false),
        new Pizza(17L, "Calzone", new BigDecimal(4), false));
        Map<Long, Pizza> pizzas1 = new LinkedHashMap<>();
        // de key van de entries uit de map zijn de nummers van de pizzas
        pizzas1.put(12L, new Pizza(12, "Prosciutto", new BigDecimal(4), true));
        pizzas1.put(14L, new Pizza(14, "Margehrita", new BigDecimal(5),false));
        pizzas1.put(17L, new Pizza(17, "Calzone", new BigDecimal(4), false));
        pizzas1.put(23L, new Pizza(23L, "Fungi & Olive", new BigDecimal(5),false));
        request.setAttribute("pizzas", pizzas);
        request.setAttribute("pizzas1", pizzas1);
        request.setAttribute("sterren", 5);
        requestStatistiek.voegRequestToe(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

}
