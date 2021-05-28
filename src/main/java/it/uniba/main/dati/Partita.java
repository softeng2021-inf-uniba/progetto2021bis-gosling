/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.dati;

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

    /**
     * La damiera di gioco su cui si svolger‡ la partita.
     */
    private Damiera damiera;
    /**
     * Utilizzata per salvare i dati del primo giocatore.
     */
    private Giocatore giocatore1;
    /**
     * Utilizzata per salvare i dati del secondo giocatore.
     */
    private Giocatore giocatore2;
    /**
     * Variabile utilizzata per la gestione del flusso dei turni tra giocatore1 e giocatore2.
     */
    private Turno turno;
    /**
     * Variabile booleana assume vero solo quando la partita finisce.
     */
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
    /**
     * Il costruttore di partita che inizializza tutti i suoi attributi.
     */
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
    /**
     * Controlla se esiste gia una partita avviata, altrimenti ne crea una nuova.
     */
    public static void nuovaPartita() {

        if (partitaCorrente == null) {
            System.out.println("Non ci sono partite attive; creata una nuova partita.");
            partitaCorrente = new Partita();
        } else {
            System.out.println("Una partita √® gi√† in corso.");
            //Non ancora implementata
        }
    }

    /**
     * Gestisce il flusso della partita chiamando ogni volta nuovoTurno, prima di inziare un nuovo turno controlla se la pertita non Ë finita
     */
    public void giocaPartita() {
        while (!isFinita()) {
            nuovoTurno();
        }
    }

    /**
     * Controlla di chi Ë il turno e succesivamente chiama il menuDiGioco specificando chi Ë il giocatore del turno e chi Ë il suo avversario.
     * Infine aggiorna di chi Ë il turno per il turno successivo.
     */
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

        System.out.println("√à il turno di: " + corrente.getNome() + " (" + corrente.getColore().toString() + ").");

        InterfacciaInput.menuDiGioco(corrente, avversario);

        corrente.aggiornaTempoPassato();

        if (turno == Turno.turnoGiocatore1) {
            turno = Turno.turnoGiocatore2;
        } else {
            turno = Turno.turnoGiocatore1;
        }
    }

    /**
     * Imposta a true finita, per terminare la partita.
     */
    public void finisciPartita() {
        finita = true;
    }

    /**
     * Imposta a null la partitaCorrente.
     */
    public static void azzeraPartitaCorrente() {
        partitaCorrente = null;
    }

    /**
     * Stampa il tempo passato dei due giocatori. Il comando stampa per primo il tempo del giocatore in base al turno in cui Ë stato chiamato il comando.
     */
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
                + " (" + corrente.getColore().toString() + ") " + " √®: " + corrente.getTempoPassato() + ".");
        System.out.println("Il tempo di gioco di " + avversario.getNome()
                + " (" + avversario.getColore().toString() + ") " + " √®: " + avversario.getTempoPassato() + ".");
    }
}
