/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

/**
 *
 * @author Pasquale
 */
public class Pedina {
     /* ------------ Stato ------------ */
    private final Tipo_pedina tipo;
    private final Colore colore;
     /* ------------  Costruttori ------------ */
    Pedina(Colore colore){
        this.colore=colore;
        this.tipo=Tipo_pedina.pedinaSemplice;
    }
     /* ------------ Metodi ------------*/
    public void Stampa_pedina(){
        if(this.colore==Colore.bianco){
            if(this.tipo==Tipo_pedina.pedinaRe){
                System.out.print("?");
            }
            else{
               System.out.print("?");
            }
        }
        else{
           if(this.tipo==Tipo_pedina.pedinaRe){
                System.out.print("?");
            }
            else{
               System.out.print("?");
            } 
        }
    }
}
