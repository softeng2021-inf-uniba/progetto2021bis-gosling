/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.Colore;
import java.time.LocalTime;
import it.uniba.main.types.Turno;

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
    private Partita(){
       
        damiera=Damiera.getDamiera();
        giocatore1=new Giocatore();
        /*Solo il primo giocatore, chiaramente, può scegliere il colore,
        al secondo tocca il complemento del primo*/
        giocatore2=new Giocatore(giocatore1.getNome(), giocatore1.getColoreAvversario());
        
        if(giocatore1.getColore() == Colore.bianco)
        {
            turno = Turno.turnoGiocatore1;
        }
        else
        {
            turno = Turno.turnoGiocatore2;
        }
        
        System.out.println("La partita inizia ora.");
        
        this.nuovoTurno();
    }
    
    /* ------------ Get & Set ------------ */
    public static Partita getPartita()
    {
        return partitaCorrente;
    }
    
    /* ------------ Metodi ------------ */
    public static void nuovaPartita(){
        
        if(partitaCorrente == null)
        {
            System.out.println("Non ci sono partite attive; hai creato creato una nuova partita.");
            partitaCorrente = new Partita();
        }
        else
        {
            System.out.println("Una partita è già in corso; cosa vuoi fare?");
            //Poi si pensa
        }
    }
    
    public void nuovoTurno()
    {
        Giocatore corrente;
        
        if(turno == Turno.turnoGiocatore1)
        {
            corrente = giocatore1;
        }
        else
        {
            corrente = giocatore2;
        }
        
        System.out.println("È il turno di " + corrente.getNome() + ".");
        corrente.iniziaMossa();
    }
    
    public void stampaTempoPassato(){
        System.out.println("Il tempo passato dall'inizio della partita è: ");
    }
}

