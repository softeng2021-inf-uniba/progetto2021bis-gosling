/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.eccezioni;

/**
 *
 * @author Pasquale
 */
public final class EccezioneSpostamento extends Exception {

    public EccezioneSpostamento(final String string) {
        super(string);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}