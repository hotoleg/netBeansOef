/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oleg.kolokolnikov
 */
@WebServlet(name = "PizzaBestellenServlet", urlPatterns = {"/pizzas/pizzasbestellen.htm"})
public class PizzaBestellenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzabestellen.jsp";
    private static final String REDIRECT_URL = "/pizzasbestellen";
    private static final String MANDJE = "mandje"; 
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    

    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.setAttribute("allePizzas", pizzaDAO.findAll()); 
        HttpSession session = request.getSession(false);
        if (session != null) {
                Set<Long> mandje = (Set<Long>) session.getAttribute(MANDJE); 
            if (mandje != null) { 
                List<Pizza> pizzasInMandje = new ArrayList<Pizza>();
                for (long pizzaNr : mandje) { 
                    pizzasInMandje.add(pizzaDAO.read(pizzaNr));
                }
                request.setAttribute("pizzasInMandje", pizzasInMandje);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
        
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameterValues("nummer") != null) {
            HttpSession session = request.getSession(); 
            Set<Long> pizzaNrsInMandje=(Set<Long>)session.getAttribute(MANDJE); 
            if (pizzaNrsInMandje == null) { 
            pizzaNrsInMandje = new LinkedHashSet<Long>(); 
            }
            try {
                for (String pizzaNrAlsString : request.getParameterValues("nummer")) {
                    pizzaNrsInMandje.add(Long.parseLong(pizzaNrAlsString)); 
                }
                session.setAttribute(MANDJE, pizzaNrsInMandje); 
            } catch (Exception ex) {
            // een hacker heeft in de parameter nummer niet-getallen geplaatst
            }
        }
        response.sendRedirect(response.encodeRedirectURL(
        request.getContextPath() + REDIRECT_URL));
    }

}

    

