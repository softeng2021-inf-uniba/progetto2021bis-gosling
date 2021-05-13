/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.types;

/**
 * Tipo Classe: <<Entity>>
 * 
 * Registra le informazioni di una posizione
 * 
 */
public final class Posizione {
    /* ------------ Stato ------------ */
    private int riga;
    private int colonna;
    /* ------------ Costruttori ------------ */
    public Posizione() {
    }
    public Posizione(final int rigaIn, final int colonnaIn) {
        this.riga = rigaIn;
        this.colonna = colonnaIn;
    }
    /* ------------ Get & Set ------------ */
    public int getRiga() {
        return riga;
    }

    public int getColonna() {
        return colonna;
    }

    public void setRiga(final int rigaIn) {
        this.riga = rigaIn;
    }

    public void setColonna(final int colonnaIn) {
        this.colonna = colonnaIn;
    }
}
