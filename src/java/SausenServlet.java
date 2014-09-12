/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oleg.Kolokolnikov
 */
@WebServlet("/sausen")
public class SausenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/sausen.jsp";
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         List<Saus> sausen = Arrays.asList(
        new Saus(1L, "cocktail", Arrays.asList("mayonaise", "ketchup", "cognac")),
        new Saus(2L, "mayonnaise", Arrays.asList("ei", "mosterd")),
        new Saus(3L, "mosterd", Arrays.asList("mosterd", "azijn", "witte wijn")),
        new Saus(4L, "tartare", Arrays.asList("mayonaise", "augurk", "tabasco")),
        new Saus(3L, "vinaigrette",Arrays.asList("olijfolie","mosterd","azijn")));
         request.setAttribute("sausen", sausen);
         request.getRequestDispatcher(VIEW).forward(request, response);
    }

    

}
