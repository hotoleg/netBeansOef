/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import be.vdab.entities.Adres;
import be.vdab.entities.Persoon;
import be.vdab.util.RequestStatistiek;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oleg.kolokolnikov
 */
@WebServlet(urlPatterns="/welkom.htm", name="welkomservlet")
public class WelkomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/welkom.jsp";
    private final Persoon zaakvoerder = new Persoon();
    private int aantalKeerBekeken;
    private final RequestStatistiek requestStatistiek = new RequestStatistiek();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("boodschap", new Begroeting());
        request.setAttribute("zaakvoerder", zaakvoerder);
        request.setAttribute("aantalKeerBekeken", verhoogAantalKeerBekeken());
        requestStatistiek.voegRequestToe(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }
    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        zaakvoerder.setVoornaam(servletContext.getInitParameter("voornaam"));
        zaakvoerder.setFamilienaam(servletContext.getInitParameter("familienaam"));
        zaakvoerder.setAantalKinderen(
        Integer.valueOf(servletContext.getInitParameter("aantalKinderen")));
        zaakvoerder.setGehuwd(Boolean.valueOf(servletContext.getInitParameter("gehuwd")));
    }
    private synchronized int verhoogAantalKeerBekeken() {
        return ++aantalKeerBekeken;
    }

}
