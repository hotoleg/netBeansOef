/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author Oleg.Kolokolnikov
 */
@WebListener
public class MandjeListener implements HttpSessionAttributeListener {

    private static final String MANDJE = "mandje"; //(3)
    private static final String AANTAL_MANDJES = "aantalMandjes"; //(4)
    
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) { //(5)
        if (event.getName().equals(MANDJE)) { //(6)
            verhoogMandjeTeller(event.getSession().getServletContext());
        }
    }
    private synchronized void verhoogMandjeTeller( //(7)
    ServletContext servletContext) {
        Integer mandjeTeller =
        (Integer) servletContext.getAttribute(AANTAL_MANDJES); //(8)
        if (mandjeTeller == null) { //(9)
            mandjeTeller = 1;
        } else {
            mandjeTeller++; //(10)
        }
        servletContext.setAttribute(AANTAL_MANDJES, mandjeTeller);
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) { //(11)
        if (event.getName().equals(MANDJE)) {
            verlaagMandjeTeller(event.getSession().getServletContext());
        }
    }
    private synchronized void verlaagMandjeTeller(
        ServletContext servletContext) {
        Integer mandjeTeller =
        (Integer) servletContext.getAttribute(AANTAL_MANDJES);
        mandjeTeller--; //(12)
        servletContext.setAttribute(AANTAL_MANDJES, mandjeTeller);
    }
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) { //(13)
    }
}
