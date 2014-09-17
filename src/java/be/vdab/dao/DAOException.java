/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.dao;

/**
 *
 * @author Oleg.Kolokolnikov
 */
public class DAOException extends RuntimeException{
    private static final long serialVersionUID = 1L; 
    public DAOException(String message) { 
        super(message);
    }
    
    public DAOException(String message, Throwable cause) { 
        super(message, cause);
    }
}