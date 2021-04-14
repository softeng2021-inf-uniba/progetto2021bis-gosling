/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.Colore;
import java.time.LocalTime;
import it.uniba.main.types.Turno;
import java.util.Scanner;

/**
 *
 * @author domenico francesco e giuseppe
 */
public class Partita {

    /* ------------ Stato ------------ */
    private static Partita partitaCorrente;

    private Damiera damiera;
    public Giocatore giocatore1;
    private Giocatore giocatore2;
    private Turno turno;

    /* ------------ Costruttori ------------ */
    private Partita() {

        damiera = Damiera.getDamiera();
        giocatore1 = new Giocatore();
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2 = new Giocatore(giocatore1.getNome(), giocatore1.getColoreAvversario());

        if (giocatore1.getColore() == Colore.bianco) {
            turno = Turno.turnoGiocatore1;
        } else {
            turno = Turno.turnoGiocatore2;
        }

        System.out.println("La partita inizia ora.");

        this.nuovoTurno();
    }

    /* ------------ Get & Set ------------ */
    public static Partita getPartita() {
        return partitaCorrente;
    }

    /* ------------ Metodi ------------ */
    public static void nuovaPartita() {

        if (partitaCorrente == null) {
            System.out.println("Non ci sono partite attive; hai creato creato una nuova partita.");
            partitaCorrente = new Partita();
        } else {
            System.out.println("Una partita è già in corso; cosa vuoi fare?");
            //Poi si pensa
        }
    }

    public void nuovoTurno() {
        Giocatore corrente;
        Giocatore avversario;

        if (turno == Turno.turnoGiocatore1) {
            corrente = giocatore1;
            avversario = giocatore2;
        } else {
            corrente = giocatore2;
            avversario = giocatore1;
        }

        System.out.println("È il turno di " + corrente.getNome() + ".");

        sceltaComando(corrente, avversario);

    }

    public void stampaTempoPassato() {

        Giocatore corrente;
        Giocatore avversario;

        if (turno == Turno.turnoGiocatore1) {
            corrente = giocatore1;
            avversario = giocatore2;
        } else {
            corrente = giocatore2;
            avversario = giocatore1;
        }
        
        corrente.aggiornaTempoPassato();
        System.out.println("Il tempo di gioco di " + corrente.getNome() + " (" + corrente.getColore().toString() + ") " + " è: " + corrente.getTempoPassato());
        System.out.println("Il tempo di gioco di " + avversario.getNome() + " (" + avversario.getColore().toString() + ") " + " è: " + avversario.getTempoPassato());
    }

    public void abbandona(Giocatore rinunciatario, Giocatore avversario)
    {
        //Tocca a Fra
        System.out.println(rinunciatario.getNome() + " (" + rinunciatario.getColore().toString() + ") " + " ha abbandonato il gioco.");
        System.out.println(avversario.getNome() + " (" + avversario.getColore().toString() + ") " + " ha vinto.");
    }
    
    public void sceltaComando(Giocatore corrente, Giocatore avversario) {
        boolean isExiting = false;
        String answer;

        corrente.iniziaMossa();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Digitare un comando valido...");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                switch (answer) {
                    case "help":
                        Help.getMenuHelp();
                        break;
                    case "numeri":
                        Damiera.getDamiera().stampaNumeri();
                        break;
                    case "damiera":
                        Damiera.getDamiera().stampaPedine();
                        break;
                    case "tempo":
                        stampaTempoPassato();
                        break;
                    case "abbandona":
                        abbandona(corrente, avversario);
                        isExiting = true;
                        break;
                    default:
                        System.out.println("Comando inserito non valido");
                        System.out.println("Per sapere quali comandi sono validi digitare help");
                        break;
                }
            }
        } while (isExiting == false);
    }
}
