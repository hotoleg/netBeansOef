/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package one;

/**
 *
 * @author Oleg.Kolokolnikov
 */
public class Two implements Runnable{
    private static String tekst=".\n.\n..\n..\n.\n.\n.\n..\n.\n..\n..\n..\n..\n..\n...\n...\n........";
    private static String tekst1="\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\\\\\\\\\\\\\\n\\\\\\\\\\\\\\n\\\\\\\n";
    public Two() {
    }
    
    

    @Override
    public void run() {
        for (int i = 0; i < tekst1.length(); i++) { 
             System.out.print(tekst.charAt(i));
             System.out.print(tekst1.charAt(i));
            try { 
                Thread.sleep(300); 
            } catch (InterruptedException ex) { 
                System.err.println("\\\\\\\\\\\\\\\\"); 
            } 
        }
    }
}
