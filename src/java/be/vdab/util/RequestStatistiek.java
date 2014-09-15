/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author oleg.kolokolnikov
 */
public class RequestStatistiek {
    private final static String STATISTIEK = "statistiek";
    //@SuppressWarnings("unchecked")
    public synchronized void voegRequestToe(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        String url = request.getRequestURI();
        int index = url.indexOf(";jsessionid=");
        if (index != -1) {
            // onderdeel met session id verwijderen uit URL:
            url = url.substring(0, index);
        }
        Map<String, Integer> statistiek =(Map<String, Integer>) context.getAttribute(STATISTIEK); 
        if (statistiek == null) {
            statistiek = new ConcurrentHashMap<String, Integer>(); 
        }
        if (statistiek.containsKey(url)) {
            statistiek.put(url, statistiek.get(url) + 1); 
        } else {
            statistiek.put(url, 1); 
        }
        context.setAttribute(STATISTIEK, statistiek);
        }
}
