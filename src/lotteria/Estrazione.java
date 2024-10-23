/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotteria;
import java.util.Random;

/**
 *
 * @author monica ciuchetti
 */
public class Estrazione extends Thread {
    //private int numero;
    public int vincitori[];
    private int[][] matrice;
    private int n;
    private int vcont;
    private boolean[][] premiati;
    
    
    /**
     * 
     * Metodo costruttore
     */   
    public Estrazione(int n) {
        //this.numero=10;
        this.n = n;
        this.matrice = new int[n][n];
        this.premiati = new boolean[n][n];
        this.vincitori = new int [3];
        this.vcont = 0;
       }
    

    /**
    * 
    * Metodo per visualizzare la matrice dei numeri estratti
    */
 
    
    /**
    * 
    * Metodo per visualizzare i vincitori dell'estrazione
    */
    public void stampaVincitori() {
        // stampa array dei vincitori
        System.out.println("Vincitori: ");
        for(int i = 0; i < vcont; i++){
        System.out.println("Posizione: " + (i+1) + "Giocatore con ID: " + vincitori[i]);
        }
        }

    /**
    * 
    * Metodo per verificare il numero scelto dal giocatore e determinare i vincitori
    */
    public void verifica(int numero, int idGiocatore) {
        if (vcont >= 3){
         System.out.println("Il giocatore con ID: " + idGiocatore + " non puo' vincere piu' premi"); 
         return;
        }  
    
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
         if (matrice[i][j] == numero && !premiati[i][j]) {
                    premiati[i][j] = true; 
                    vincitori[vcont] = idGiocatore;
                    vcont++;
                    //int premio = (i + 1) * (j + 1) * 10;
                    System.out.println("Il giocatore con id: " + idGiocatore + " ha scelto il numero: " + numero + " e ha vinto!!!");
                    return;
    }   
  }
 }
System.out.println("Il giocatore con id: " + idGiocatore + " ha perso!!!"); 
}
    

    /**
    * 
    * Metodo per eseguire il thread
    */
    public void run() {
        //stampa iniziale
         System.out.println("Inizio dell'estrazione...");

        // estrazione dei numeri
         
        Random random = new Random();
    for (int i = 0; i < n; i++){
        for (int j = 0; j < n; j++){
             matrice[i][j] = random.nextInt(100) +1;
             premiati[i][j] = false;
   }
    }
        
        // stampa matrice
        
        System.out.println("Numeri estratti: ");
       for(int i = 0; i < n; i++){
           for(int j = 0; j < n; j++){
            System.out.print(matrice[i][j] + " ");
         }
         System.out.println();
    }
    System.out.println("Fine dell'estrazione!!!");
    }
}


