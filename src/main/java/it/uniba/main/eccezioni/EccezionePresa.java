/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.eccezioni;

/**
 * <<noECB>>
 * Gestisce le eccezioni per le prese
 */
public final class EccezionePresa extends Exception {
    /**
     * Sovrascrive il messaggio standard delle eccezioni
     * @param string 
     */
    public EccezionePresa(final String string) {
        super(string);
    }
    /**
     * Ritorna il messaggio dell'eccezione
     * @return il messaggio dell'eccezione
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
