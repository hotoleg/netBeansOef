/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
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
@WebServlet (urlPatterns="/SluitingsDagen", name="sluitingservlet")
public class SluitingsDagen extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "WEB-INF/JSP/welkom.jsp";
private final Adres adres = new Adres();
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("afbeelding", new Afbeelding());
        request.setAttribute("adres", adres);
        RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = this.getServletContext();
        adres.setStraat(servletContext.getInitParameter("straat"));
        adres.setHuisNr(servletContext.getInitParameter("huisnummer"));
        Gemeente gemeente = new Gemeente();
        gemeente.setGemeente(servletContext.getInitParameter("gemeente"));
        gemeente.setPostCode(servletContext.getInitParameter("postcode"));
        adres.setGemeente(gemeente);
    }

}
