/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.time.LocalTime;

/**
 *
 * @author domenico francesco e giuseppe
 */

public class Partita {
   /* ------------ Stato ------------ */
    private Damiera damiera;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    private LocalTime tempoInizioPartita;
    private LocalTime tempoPassato;
    
    /* ------------ Costruttori ------------ */
    Partita(){
       
        damiera=Damiera.getDamiera();
        giocatore1=new Giocatore();
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2=new Giocatore(giocatore1.getColoreAvversario());
        tempoInizioPartita=LocalTime.now();
    }
    
    /* ------------ Get & Set ------------ */
    private LocalTime getTempoPassato(){
       
        return(this.calcolaTempoPassato());
    }
    
    /* ------------ Metodi ------------ */
    private LocalTime calcolaTempoPassato(){
        /*Se ne occuperà Giuseppe, per ora ritorna solo il tempo attuale*/
        return(LocalTime.now());
    }
    
    public void stampaTempoPassato(){
        System.out.println("Il tempo passato dall'inizio della partita è: "+ getTempoPassato().toString());
    }
}

