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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new One());
        thread1.start();
        Thread thread2 = new Thread(new One());
        thread2.start();
        Thread thread3 = new Thread(new Two());
        thread3.start();
        Thread thread4 = new Thread(new Two());
        thread4.start();
        try { 
            thread1.join(); 
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException ex) { System.err.println(ex); }
    }
    
}
