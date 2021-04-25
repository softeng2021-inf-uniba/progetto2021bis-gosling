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
import it.uniba.main.interfacce.InterfacciaInput;

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
    private boolean finita;

    /* ------------ Costruttori ------------ */
    private Partita() {

        damiera = Damiera.getDamiera();
        giocatore1 = new Giocatore(1);
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2 = new Giocatore(2);
        finita=false;

        if (giocatore1.getColore() == Colore.bianco) {
            turno = Turno.turnoGiocatore1;
        } else {
            turno = Turno.turnoGiocatore2;
        }

        System.out.println("La partita inizia ora.");
    }

    /* ------------ Get & Set ------------ */
    public static Partita getPartita() {
        return partitaCorrente;
    }
    
    public boolean isFinita(){
        return finita;
    }

    /* ------------ Metodi ------------ */
    
    public void finisciPartita(){
        finita=true;
    }
    
    public static void nuovaPartita() {

        if (partitaCorrente == null) {
            System.out.println("Non ci sono partite attive; creata una nuova partita.");
            partitaCorrente = new Partita();
        } else {
            System.out.println("Una partita è già in corso; cosa fare?");
            //Poi si pensa
        }
    }

    public static void azzeraPartitaCorrente() {
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

        InterfacciaInput.menuDiGico(corrente, avversario);
       if(turno==Turno.turnoGiocatore1){
           turno=Turno.turnoGiocatore2;
       }
       else{
           turno=Turno.turnoGiocatore1;
       }
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
    
    public void giocaPartita(){
        while(!isFinita()){
            nuovoTurno();
        }
    }
}
