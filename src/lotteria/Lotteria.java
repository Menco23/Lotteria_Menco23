/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Menculini Tommaso
 */
public class Lotteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 3;
        Estrazione e = new Estrazione(n);
        
        System.out.println("INIZIO DEL GIOCOOO: ");
        e.start();
        
        try {
            e.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Giocatore g1 = new Giocatore(1, "Filippo", e);
        Giocatore g2 = new Giocatore(2, "Tommaso", e);
        Giocatore g3 = new Giocatore(3, "Riccardo", e);
        Giocatore g4 = new Giocatore(4, "David", e);
      
        g1.start();
        try {
            g1.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2.start();
        try {
            g2.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g3.start();
        try {
            g3.join();
           } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }

        g4.start();
        try {
            g4.join();
            } catch (InterruptedException ex) {
            Logger.getLogger(Lotteria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          //istanza ed avvio del thread Estrazione
         System.out.println();
         System.out.println("Podio:");
           System.out.println("3 posto: " + e.vincitori[2]);
           System.out.println("2 posto: " + e.vincitori[1]);
           System.out.println("1 posto: " + e.vincitori[0]);
         System.out.println();
        
       System.out.println("FINE DEL GIOCO !!!");
    }
}
   