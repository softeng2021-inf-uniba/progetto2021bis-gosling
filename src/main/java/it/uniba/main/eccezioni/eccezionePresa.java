/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.eccezioni;

/**
 * <<noECB>>
 * @author Pasquale
 */
public class eccezionePresa extends Exception {

    private final String message;
    
    public eccezionePresa(String string) {
        this.message = string;
    }
    @Override
    public String getMessage() {
        return this.message; 
    }
}
