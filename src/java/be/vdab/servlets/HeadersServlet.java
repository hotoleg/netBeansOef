/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
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
@WebServlet(name = "HeadersServlet", urlPatterns = {"/headers"})
public class HeadersServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
private static final String VIEW = "/WEB-INF/JSP/headers.jsp";
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String,String> headers=new LinkedHashMap<String,String>();
        Enumeration<String> headerNames=request.getHeaderNames();
        while (headerNames.hasMoreElements()) { // zolang er headernamen zijn
            String headerName=headerNames.nextElement(); // de volgende headernaam
            String headerValue=request.getHeader(headerName);
            headers.put(headerName, headerValue);
        }
        request.setAttribute("headers", headers);
        RequestDispatcher dispatcher=request.getRequestDispatcher(VIEW);
        dispatcher.forward(request, response);
    }
    
}
