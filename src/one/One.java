/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package one;

import java.math.BigDecimal;
import static java.math.BigDecimal.ONE;

/**
 *
 * @author Oleg.Kolokolnikov
 */
public class One implements Runnable{
    private static String tekst="..........................................................\n";
    private static String tekst1="\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\n";
    public One() {
    }
    
    //bhgghfhg

    @Override
    public void run() {
        for (int i = 0; i < tekst.length(); i++) { 
             System.out.print(tekst.charAt(i));
             System.out.print(tekst1.charAt(i));
            try { 
                Thread.sleep(300); 
            } catch (InterruptedException ex) { 
                System.err.println(ex); 
            } 
        }
    }
}
