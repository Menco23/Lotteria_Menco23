/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author monica ciuchetti
 */
public class Giocatore extends Thread{
   private int idGiocatore;
   private String nomeGiocatore;
   private Estrazione estrazione;
   private int numScelto;
   
   
 public Giocatore(int idGiocatore, String nomeGiocatore, Estrazione estrazione) {
       this.idGiocatore=idGiocatore;
       this.nomeGiocatore=nomeGiocatore;
       this.estrazione=estrazione;
       this.numScelto = (int) (Math.random() * 100)*1;
    }

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
          System.out.println();
        System.out.println("Giocatore: " + nomeGiocatore + " ha scelto il numero: " + numScelto);
       // verifica del risutlato
       for(int i=3;i>=0;i-- ){
       System.out.println(i);
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Giocatore.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("errore sleep");
            }
       }
       System.out.println("ho verificato il numero inserito");
       estrazione.verifica(numScelto, idGiocatore);
    }
}
