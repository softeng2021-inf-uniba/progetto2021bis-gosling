/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.interfacce.InterfacciaInput;

/**
 * Tipo Classe: <<Control>>
 *
 * Gestisce il flusso di un partita, i turni e i giocatori.
 *
 */
public final class Partita {

    /* ------------ Stato ------------ */
    private static Partita partitaCorrente;

    private Damiera damiera;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private Turno turno;
    private boolean finita;
    /* ------------ Sottoclassi ------------ */
    /**
     *  <<noECB>>
     * 
     *  Definisce il turno
     */
    public enum Turno {
        turnoGiocatore1,
        turnoGiocatore2
    }
    /* ------------ Costruttori ------------ */
    private Partita() {

        damiera = Damiera.getDamiera();
        damiera.preparaDamiera();

        giocatore1 = new Giocatore(1);
        giocatore2 = new Giocatore(2);

        turno = Turno.turnoGiocatore1;

        finita = false;
        System.out.println("La partita inizia ora.");
    }

    /* ------------ Get & Set ------------ */
    public static Partita getPartita() {
        return partitaCorrente;
    }

    public boolean isFinita() {
        return finita;
    }

    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    /* ------------ Metodi ------------ */
    public static void nuovaPartita() {

        if (partitaCorrente == null) {
            System.out.println("Non ci sono partite attive; creata una nuova partita.");
            partitaCorrente = new Partita();
        } else {
            System.out.println("Una partita è già in corso.");
            //Non ancora implementata
        }
    }

    public void giocaPartita() {
        while (!isFinita()) {
            nuovoTurno();
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

        System.out.println("È il turno di: " + corrente.getNome() + " (" + corrente.getColore().toString() + ").");

        InterfacciaInput.menuDiGioco(corrente, avversario);

        corrente.aggiornaTempoPassato();

        if (turno == Turno.turnoGiocatore1) {
            turno = Turno.turnoGiocatore2;
        } else {
            turno = Turno.turnoGiocatore1;
        }
    }

    public void finisciPartita() {
        finita = true;
    }

    public static void azzeraPartitaCorrente() {
        partitaCorrente = null;
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
        System.out.println("Il tempo di gioco di " + corrente.getNome()
                + " (" + corrente.getColore().toString() + ") " + " è: " + corrente.getTempoPassato() + ".");
        System.out.println("Il tempo di gioco di " + avversario.getNome()
                + " (" + avversario.getColore().toString() + ") " + " è: " + avversario.getTempoPassato() + ".");
    }
}
