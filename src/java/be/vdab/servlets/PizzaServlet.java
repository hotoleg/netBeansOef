/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import be.vdab.util.RequestStatistiek;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    private Iterable<Pizza> pizzas;
    
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    request.setAttribute("sterren", 5);
    List<Pizza> pizzas = pizzaDAO.findAll();
    String pizzaFotosPad = this.getServletContext().getRealPath("/pizzafotos");
    Set<Long> pizzaNummersMetFoto = new HashSet<Long>();
    for (Pizza pizza : pizzas) {
        File file = new File(pizzaFotosPad + "/" + pizza.getNummer() + ".jpg");
        if (file.exists()) { // is er foto voor deze pizza ?
            pizzaNummersMetFoto.add(pizza.getNummer());
        }
    }
    requestStatistiek.voegRequestToe(request);
    request.setAttribute("pizzas", pizzas);
    request.setAttribute("pizzaNummersMetFoto", pizzaNummersMetFoto);
    RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
    dispatcher.forward(request, response);
}

}
