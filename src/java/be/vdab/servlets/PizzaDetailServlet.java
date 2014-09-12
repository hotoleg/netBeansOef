/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import java.io.IOException;
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
@WebServlet(name = "PizzaDetailServlet", urlPatterns = {"/pizzadetail"})
public class PizzaDetailServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
        private static final String VIEW = "/WEB-INF/JSP/pizzadetail.jsp";
        private final PizzaDAO pizzaDAO = new PizzaDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            long nummer = Long.parseLong(request.getParameter("nummer"));
            Pizza pizza = pizzaDAO.read(nummer);
            if (pizza == null) {
            // pizza met dit nummer komt niet voor in de database
                request.setAttribute("fout", "Pizza niet gevonden");
            } else {
                request.setAttribute("pizza", pizzaDAO.read(nummer));
            }
        } catch (NumberFormatException ex) {
        // request parameter nummer komt niet voor of bevat geen getal
            request.setAttribute("fout", "Nummer niet correct");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }
        
}

   


