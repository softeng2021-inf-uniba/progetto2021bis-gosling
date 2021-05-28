/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

/**
 * Tipo Classe <<Boundary>>
 * 
 * Si occupa della gestione e stampa dell'elenco dei comandi
 * 
 */
public final class Help {
    /**
     * Rende Help una classe singleton
     */
    private static Help singleIstance = null;
    
    /**
     * Costruttore della classe Help
     * 
     * Essendo una classe con soli metodi statici, il costruttore e' privato
     */
    private Help() {
    }
    
    /**
     * Permette di ottenere l'unica istanza di help e lo inizializza se non esiste
     * @return l'unica istanza di help 
     */
    public static Help getHelp() {
        if (singleIstance == null) {
            singleIstance = new Help();
        }
        return singleIstance;
    }

 /* ------------ Metodi ------------*/
    /**
     * Stampa di tutti i comandi possibili.
     * 
     * I comandi sono:
     * - gioca
     * - numeri
     * - esci
     * - damiera
     * - abbandona
     * - tempo
     * - prese
     * - mosse
     */
    public static void stampaHelpMenu() {
        System.out.println("");
        System.out.println("+------------------ HELP ------------------+");
        System.out.println("Benvenuto nell'applicazione di Dama sviluppata dal Team gosling!");
        System.out.println("Questa applicazione ti permette di giocare a dama tramite linea di comando.");
        System.out.println("Per interagire con l'applicazione devi digitare il comando che vuoi eseguire");

        System.out.println("Digita 'gioca' se vuoi iniziare una partita");
        System.out.println("Digita 'numeri' per visualizzare la damiera numerata");
        System.out.println("Digita 'esci' per uscire dall'applicazione");
        System.out.println("");
        System.out.println("Se sei in partita, digita 'damiera' per visualizzare lo stato attuale della damiera");
        System.out.println("Se sei in partita, digita 'abbandona' per abbandonare l"
                + "a partita, dando la vittoria al tuo avversario");
        System.out.println("Se sei in partita, digita 'tempo' per visualizzare il "
                + "tempo trascorso dall'inizio del gioco");
        System.out.println("Se sei in partita, digitare 'prese' per visualizzare le prese del bianco e del nero:");
        System.out.println("Se sei in partita, digitare 'mosse' per visualizzare le mosse effettuate dai giocatori");
        System.out.println("Se sei in partita, per muovere le pedine digitare le coordinate in notazione algebrica:");

        System.out.println("Movimento Semplice: 21-18");
        System.out.println("Presa Semplice: 14x21");

        System.out.println("+------------------ FINE HELP ------------------+");
    }
}
