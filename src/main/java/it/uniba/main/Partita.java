/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.Colore;
import java.time.LocalTime;

/**
 *
 * @author domenico francesco e giuseppe
 */

public class Partita {
   /* ------------ Stato ------------ */
    private static Partita partitaCorrente;
    
    private Damiera damiera;
    private Giocatore giocatore1;
    private Giocatore giocatore2;
    
    /* ------------ Costruttori ------------ */
    Partita(){
       
        damiera=Damiera.getDamiera();
        giocatore1=new Giocatore(1);
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2=new Giocatore(2, giocatore1.getColoreAvversario());
        
        if(giocatore1.getColore() == Colore.bianco)
        {
            giocatore1.iniziaMossa();
        }
        else
        {
            giocatore2.iniziaMossa();
        }
    }
    
    /* ------------ Get & Set ------------ */
    private LocalTime getTempoPassato(){
       
        return(this.calcolaTempoPassato());
    }
    
    /* ------------ Metodi ------------ */
    public static void nuovaPartita(){
        
        if(partitaCorrente == null)
        {
            System.out.println("Non ci sono partite attive; hai creato creato una nuova partita!");
            partitaCorrente = new Partita();
        }
        else
        {
            System.out.println("Una partita è già in corso; cosa vuoi fare?");
            //Poi si pensa
        }
    }
    
    public static Partita getPartita()
    {
        return partitaCorrente;
    }
    
    private LocalTime calcolaTempoPassato(){
        /*Se ne occuperà Giuseppe, per ora ritorna solo il tempo attuale*/
        return(LocalTime.now());
    }
    
    public void stampaTempoPassato(){
        System.out.println("Il tempo passato dall'inizio della partita è: "+ getTempoPassato().toString());
    }
}

