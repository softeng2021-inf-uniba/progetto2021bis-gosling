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
public class Posizione {
    public int riga;
    public int colonna;

    public Posizione()
    {
        
    }
    public Posizione(int riga, int colonna) {
        this.riga = riga;
        this.colonna = colonna;
    }
}
