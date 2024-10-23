
# Sistema Lotteria

## Scopo del Progetto
Lo scopo di questo progetto è simulare un sistema di lotteria in cui più giocatori (rappresentati da thread) selezionano dei numeri, mentre un thread separato (la classe `Estrazione`) determina i vincitori in base a delle regole predefinite. Il sistema consente fino a tre vincitori e assegna premi ai giocatori che indovinano i numeri corretti. Il progetto dimostra l'uso della concorrenza tramite i thread di Java e l'interazione di base tra gli oggetti che rappresentano i giocatori e il processo della lotteria.

## Classi Principali

### 1. `Estrazione`
Questa classe estende `Thread` ed è responsabile della gestione dell'estrazione dei numeri e della determinazione dei vincitori. Contiene una matrice di numeri (`matrice`), flag per i numeri già premiati (`premiati`), e un array di vincitori (`vincitori`).

#### Metodi Principali:
- **`verifica(int numero, int idGiocatore)`**:  
  Questo metodo controlla se il numero selezionato da un giocatore è presente nella matrice. Se il numero non è stato precedentemente premiato e ci sono ancora posti disponibili per i premi (fino a tre vincitori), il giocatore viene aggiunto alla lista dei vincitori.

  ```java
  public void verifica(int numero, int idGiocatore) {
      if (vcont >= 3) {
          System.out.println("Il giocatore con ID: " + idGiocatore + " non puo' vincere piu' premi"); 
          return;
      }  
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (matrice[i][j] == numero && !premiati[i][j]) {
                  premiati[i][j] = true; 
                  vincitori[vcont] = idGiocatore;
                  vcont++;
                  System.out.println("Il giocatore con id: " + idGiocatore ha scelto il numero vincente " + numero);
                  return;
              }
          }
      }
      System.out.println("Il numero scelto non è presente nella matrice.");
  }
  ```

  Questo metodo indica se il numero scelto è vincente e gestisce i casi in cui un giocatore ha già vinto il numero massimo di premi.

- **`stampaVincitori()`**:  
  Visualizza i vincitori della lotteria.

### 2. `Giocatore`
Questa classe rappresenta un giocatore nella lotteria ed estende `Thread`. Simula un giocatore che seleziona un numero e richiede la verifica alla classe `Estrazione` per vedere se ha vinto.

#### Metodi Principali:
- **`run()`**:  
  Simula il processo di selezione del numero da parte di un giocatore e la richiesta di verifica.

### 3. `Lotteria`
Questa è la classe principale che inizializza i thread della lotteria e dei giocatori, orchestrando l'intero gioco.

#### Metodi Principali:
- **`main(String[] args)`**:  
  Inizializza la lotteria con l'estrazione (`Estrazione`) e crea più giocatori (istanze di `Giocatore`). Ogni giocatore viene avviato e partecipa al processo di estrazione per determinare i vincitori.

## Librerie Utilizzate
Il progetto utilizza le seguenti librerie standard di Java:
- `java.util.Random`: Utilizzata per generare numeri casuali nella matrice della lotteria.
- `java.util.logging.Logger`: Utilizzata per la gestione degli errori nel flusso del programma.
- `java.util.concurrent.Thread`: Utilizzata per la concorrenza, simulando giocatori e il processo di estrazione che operano simultaneamente.

## Scenari Alternativi
1. **Nessun Numero Vincente**:  
   Se nessun giocatore seleziona un numero vincente, il sistema segnala che il numero scelto dal giocatore non è presente nella matrice.
   
2. **Numero Massimo di Vincitori Raggiunto**:  
   Una volta che tre giocatori hanno vinto, qualsiasi altro giocatore che tenta di verificare il proprio numero verrà informato che non ci sono più premi disponibili.
   
3. **Problemi di Concorrenza**:  
   I giocatori possono tentare di verificare i loro numeri contemporaneamente. Il sistema gestisce questo assicurandosi che solo i primi tre vincitori vengano premiati, indipendentemente dall'ordine di esecuzione dei thread.

## Commento sull'Esecuzione
- Il programma inizia con l'inizializzazione della matrice della lotteria nella classe `Estrazione`.
- I giocatori vengono creati e vengono assegnati degli ID. Ogni giocatore seleziona un numero e richiede la verifica.
- La classe `Estrazione` gestisce la verifica, premiando fino a tre vincitori.
- Una volta che tutti i giocatori hanno completato il loro turno, il sistema visualizza i vincitori in ordine.
- Il programma termina con l'output finale dei primi tre vincitori.
