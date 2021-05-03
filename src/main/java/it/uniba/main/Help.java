/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

/**
 *
 * @author Pasquale
 */
public class Help {

    /* ------------ Stato ------------ */
    private static Help singleIstance = null;

    /* ------------  Costruttori ------------ */
    private Help() {

    }

    public Help getHelp() {
        if (singleIstance == null) {
            singleIstance = new Help();
        }

        return singleIstance;
    }

    /* ------------ Get & Set ------------*/
 /* ------------ Metodi ------------*/
    static public void getMenuHelp() {
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
        System.out.println("Se sei in partita, digita 'abbandona' per abbandonare la partita, dando la vittoria al tuo avversario");
        System.out.println("Se sei in partita, digita 'tempo' per visualizzare il tmepo trascorso dall'inizio del gioco");
        System.out.println("Se sei in partita,digitare 'prese' per visualizzare le prese del bianco e del nero:");
        System.out.println("Se sei in partita, per muovere le pedine digitare le coordinate in notazione algebrica:");

        System.out.println("Movimento Semplice: 21-18");
        System.out.println("Presa Semplice: 14x21");

        System.out.println("+------------------ FINE HELP ------------------+");
    }
}
