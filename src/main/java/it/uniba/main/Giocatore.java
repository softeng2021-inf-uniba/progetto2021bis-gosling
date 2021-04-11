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
 * @author domen
 */
public class Giocatore {

    /* ------------ Stato ------------ */
    private Colore colore;
    private LocalTime tempoInizioMossa;
    private LocalTime tempoFineMossa;
    private LocalTime tempoRimanente;
    private int mossaCorrente;


    /* ------------ Costruttori ------------ */
    Giocatore() {
        this.tempoInizioMossa = null;
        this.tempoFineMossa = null;
        this.tempoRimanente = null;
        this.mossaCorrente = 0;

    }

    /* ------------ Get & Set ------------ */
    public void setColore(Colore colore) {
        this.colore = colore;
    }
    
    public Colore getColore(){
        return (this.colore);
    }

    public void setTempoInizioMossa(LocalTime tempoInizioMossa) {
        this.tempoInizioMossa = tempoInizioMossa;
    }

    public LocalTime getTempoInizioMossa() {
        return (this.tempoInizioMossa);
    }

    public void setTempoFineMossa(LocalTime tempoFineMossa) {
        this.tempoFineMossa = tempoFineMossa;
    }

    public LocalTime getTempoFineMossa() {
        return (this.tempoFineMossa);
    }

    public LocalTime getTempoRimanente() {
        return (this.tempoRimanente);
    }

    public LocalTime getTempoPassato() {
        LocalTime tempoPassato = LocalTime.now();
        return (tempoPassato);
    }

    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    private void incrementaMossaCorrente() {
        this.mossaCorrente++;
    }

    public void iniziaMossa() {
        this.incrementaMossaCorrente();
        this.setTempoInizioMossa(LocalTime.now());
    }

}

