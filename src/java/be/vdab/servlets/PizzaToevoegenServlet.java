/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.dao.PizzaDAO;
import be.vdab.entities.Pizza;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author oleg.kolokolnikov
 */
@WebServlet(name = "PizzaToevoegenServlet", urlPatterns = {"/pizzas/pizzatoevoegen.htm"})
@MultipartConfig
    public class PizzaToevoegenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzatoevoegen.jsp";
    private static final String REDIRECT_URL = "/pizzas";
    private final PizzaDAO pizzaDAO = new PizzaDAO();
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher=request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String> fouten = new HashMap<String, String>();
        String naam = request.getParameter("naam");
        if (naam == null || naam.isEmpty()) {
            fouten.put("naam", "verplicht");
        }
        BigDecimal prijs = null;
        try {
            prijs = new BigDecimal(request.getParameter("prijs"));
            if (prijs.compareTo(BigDecimal.ZERO) < 1) {
                fouten.put("prijs", "tik een positief getal");
            }
        } catch (Exception ex) {
            fouten.put("prijs", "tik een getal");
        }
        boolean pikant = "pikant".equals(request.getParameter("pikant"));
        Part fotoPart = request.getPart("foto"); 
        if (fotoPart != null && fotoPart.getSize() != 0) { 
            String contentType = fotoPart.getContentType();
            if (!contentType.equals("image/jpeg")
            && !contentType.equals("image/pjpeg")) { 
                fouten.put("foto", "geen JPEG foto");
            }
        }
        if (fouten.isEmpty()) {
            Pizza pizza = new Pizza(naam, prijs, pikant);
            pizzaDAO.create(pizza);
            if (fotoPart != null) {
                String pizzaFotosPad =
                this.getServletContext().getRealPath("/pizzafotos"); 
                fotoPart.write(pizzaFotosPad + "/" + pizza.getNummer() + ".jpg"); 
            }
            response.sendRedirect(request.getContextPath() + REDIRECT_URL);

        } else {
            request.setAttribute("fouten", fouten);
            RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
            dispatcher.forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
