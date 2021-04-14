/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.TipoPedina;
import it.uniba.main.types.Colore;

/**
 *
 * @author Pasquale
 */
public class Pedina {
    /* ------------ Stato ------------ */
    private TipoPedina tipo;
    private Colore colore;

    /* ------------  Costruttori ------------ */
    Pedina(Colore colore) {
        this.colore = colore;
        this.tipo = TipoPedina.pedinaSemplice;
    }
    /* ------------ Get & Set ------------*/
    private void setColore(Colore color){
        this.colore=color;
    }
    private void setTipo(TipoPedina tipo){
        this.tipo=tipo;
    }
    public Colore getColore(){
        return this.colore;
    }
    public TipoPedina getTipo(){
        return this.tipo;
    }
    /* ------------ Metodi ------------*/
    public void stampaPedina() {
        if (this.colore == Colore.bianco) {
            if (this.tipo == TipoPedina.pedinaRe) {
                System.out.print('\u26C1'); // White King
            } else {
                System.out.print('\u26C0'); // White Man
            }
        } else {
            if (this.tipo == TipoPedina.pedinaRe) {
                System.out.print('\u26C3'); // Black King
            } else {
                System.out.print('\u26C2'); // Black man
            }
        }
    }
}
