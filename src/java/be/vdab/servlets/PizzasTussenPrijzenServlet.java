/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oleg.kolokolnikov
 */
@WebServlet(name = "PizzasTussenPrijzenServlet", urlPatterns = {"/pizzas/tussenprijzen.htm"})
public class PizzasTussenPrijzenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static String VIEW="/WEB-INF/JSP/pizzastussenprijzen.jsp";
    private final PizzaDAO pizzaDAO = new PizzaDAO();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!request.getParameterMap().isEmpty()) { 
            Map<String, String> fouten = new HashMap<String, String>(); 
            BigDecimal van = null;
            BigDecimal tot = null;
            try {
                van = new BigDecimal(request.getParameter("van"));
                    } catch (Exception ex) {
                fouten.put("van", "tik een getal");
            }
            try {
                tot = new BigDecimal(request.getParameter("tot"));
            } catch (Exception ex) {
                fouten.put("tot", "tik een getal");
            }
            if (fouten.isEmpty()) {
                request.setAttribute("pizzas", pizzaDAO.findByPrijs(van, tot));
            }
                request.setAttribute("fouten", fouten);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

}
