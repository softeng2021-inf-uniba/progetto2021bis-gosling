/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.dati;

/**
 * Tipo Classe: <<Entity>>
 *
 * Registra le informazioni riguardo una pedina della dama come il colore e il
 * tipo (se semplice o dama).
 *
 */
public final class Pedina {

    /* ------------ Stato ------------ */
    /**
     * Indica se la pedina è una pedina semplice bianca o una pedina re.
     */
    private TipoPedina tipo;
    /**
     * Indica il colore di una pedina (bianco o nero).
     */
    private final Colore colore;
    /**
     * Una variabile booleana utilizzata per l'uso della stampa invertita.
     */
    private static boolean invertiColore = true;
    /* ------------ Sottoclassi ------------ */
    /**
     *  <<noECB>>
     * 
     *  Descrive il tipo delle pedine
     */
    public enum Colore {
        bianco,
        nero
    }
    /**
    * <<noECB>>
    * 
    * Rappresenta il tipo di pedina, se semplice o Dama (re)
    * 
    */
    public enum TipoPedina {
        pedinaSemplice,
        pedinaRe
    }
    /* ------------  Costruttori ------------ */
    /**
     * Il costruttore di pedina che inizializza il colore secondo un parametro in input e il tipo a pedina semplice.
     * 
     * @param coloreIn è colore che verrà assegnato a colore
     */
     public Pedina(final Colore coloreIn) {
        this.colore = coloreIn;
        this.tipo = TipoPedina.pedinaSemplice;
    }

    /* ------------ Get & Set ------------*/
     /**
      * Restituisce il colore della pedina.
      * 
      * @return è il colore della pedina
      */
    public Colore getColore() {
        return this.colore;
    }

    /**
     * Restituisce il tipo della pedina.
     * 
     * @return è il tipo della pedina
     */
    public TipoPedina getTipo() {
        return this.tipo;
    }

    /**
     * Inverte il colore in base a un parametro in input.
     * 
     * @param invertiColoreIn indica se inverti colore deve essere abilitato oppure no
     */
    public static void setInvertiColore(final boolean invertiColoreIn) {
        Pedina.invertiColore = invertiColoreIn;
    }

    /* ------------ Metodi ------------*/
    /**
     * Stampa la pedina in base al tipo, al colore e in base a inveritiColore se è impostato oppure no.
     */
    public void stampaPedina() {
        if (this.colore == Colore.bianco) {
            if (this.tipo == TipoPedina.pedinaRe) {

                if (!invertiColore) {
                    System.out.print('\u26C1'); // White King
                } else {
                    System.out.print('\u26C3'); // Black King
                }

            } else {

                if (!invertiColore) {
                    System.out.print('\u26C0'); // White Man
                } else {
                    System.out.print('\u26C2'); // Black man
                }

            }
        } else {
            if (this.tipo == TipoPedina.pedinaRe) {

                if (!invertiColore) {
                    System.out.print('\u26C3'); // Black King
                } else {
                    System.out.print('\u26C1'); // White King
                }

            } else {

                if (!invertiColore) {
                    System.out.print('\u26C2'); // Black man
                } else {
                    System.out.print('\u26C0'); // White Man
                }

            }
        }
    }

    /**
     * Cambia il tipo di una pedina a pedianRe
     */
    public void promuoviADama() {
        this.tipo = TipoPedina.pedinaRe;
    }
}
