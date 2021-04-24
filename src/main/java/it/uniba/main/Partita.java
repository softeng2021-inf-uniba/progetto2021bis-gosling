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
        giocatore1 = new Giocatore(1);
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2 = new Giocatore(2);

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
            System.out.println("Non ci sono partite attive; creata una nuova partita.");
            partitaCorrente = new Partita();
        } else {
            System.out.println("Una partita è già in corso; cosa fare?");
            //Poi si pensa
        }
    }

    public static void azzeraPartitaCorrente()
    {
        partitaCorrente = null;
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

        System.out.println("È il turno di: " + corrente.getNome() + " (" + corrente.getColore().toString() + ").");

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
        System.out.println("Il tempo di gioco di " + corrente.getNome() + " (" + corrente.getColore().toString() + ") " + " è: " + corrente.getTempoPassato() + ".");
        System.out.println("Il tempo di gioco di " + avversario.getNome() + " (" + avversario.getColore().toString() + ") " + " è: " + avversario.getTempoPassato() + ".");
    }

    public boolean vuoleAbbandonare(Giocatore rinunciatario, Giocatore avversario) {

        boolean haAbbandonato = false;

        boolean error;
        String answer;

        Scanner sc = new Scanner(System.in);

        do {
            error = false;
            System.out.println("Sicuro di voler uscire? L'avversario vincerà in caso affermativo.");
            System.out.println("Digitare 'si' o 'no'.");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                answer = answer.replaceAll(" +", "");
                switch (answer.toLowerCase()) {
                    case "si":
                        System.out.println(rinunciatario.getNome() + " (" + rinunciatario.getColore().toString() + ")" + " ha abbandonato il gioco.");
                        System.out.println(avversario.getNome() + " (" + avversario.getColore().toString() + ")" + " ha vinto per abbandono.");
                        haAbbandonato = true;
                        break;
                    case "no":
                        System.out.println("Partita non abbandonata.");
                        break;
                    default:
                        System.out.println("Digitare un comando valido...");
                        error = true;
                        break;
                }
            }
        } while (error == true);

        return haAbbandonato;
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
                answer = answer.replaceAll(" +", "");
                switch (answer.toLowerCase()) {
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
                       isExiting=vuoleAbbandonare(corrente,avversario);
                        break;
                    default:
                        System.out.println("Comando inserito non valido.");
                        System.out.println("Per sapere quali comandi sono validi digitare help.");
                        break;
                }
            }
        } while (isExiting == false);
    }
}
