/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.Colore;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Tipo Classe: <<Entity>>
 * 
 * Contiene le informazioni relative al gicoatore come il colore e il tempo passato
 * 
 */
public class Giocatore {

    /* ------------ Stato ------------ */
    private String nome;
    private Colore colore;
    private LocalTime segnaTempo;
    private LocalTime tempoPassato;
    private int mossaCorrente;
    private static final LocalTime TEMPO_DISP = LocalTime.of(0, 30, 0);
    private int contaPrese;

    /* ------------ Costruttori ------------ */
    Giocatore(int index) {

        switch (index) {
            case 1:
                this.setNome("Giocatore 1");
                this.setColore(Colore.bianco);
                break;
            case 2:
                this.setNome("Giocatore 2");
                this.setColore(Colore.nero);
                break;
            default:
                this.setNome("Giocatore 2");
                this.setColore(Colore.nero);
                break;
        }
        
        this.segnaTempo = null;
        this.tempoPassato = LocalTime.of(0, 0, 0);
        this.mossaCorrente = 0;
    }

    /* ------------ Get & Set ------------ */
    
    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private void setColore(Colore colore) {
        this.colore = colore;
    }

    public Colore getColore() {
        return (this.colore);
    }

    public Colore getColoreAvversario() {

        Colore coloreAvversario;

        if (this.getColore() == Colore.bianco) {
            coloreAvversario = Colore.nero;
        } else {
            coloreAvversario = Colore.bianco;
        }

        return (coloreAvversario);
    }

    public void setSegnaTempo(LocalTime tempoInizioMossa) {
        this.segnaTempo = tempoInizioMossa;
    }

    public LocalTime getTempoPassato() {
        return this.tempoPassato;
    }

    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    public void aggiornaTempoPassato() {
        LocalTime now = LocalTime.now();

        Long minutes = MINUTES.between(segnaTempo, now);
        Long seconds = SECONDS.between(segnaTempo, now) % 60;
        this.tempoPassato = this.tempoPassato.plusMinutes(minutes);
        this.tempoPassato = this.tempoPassato.plusSeconds(seconds);
        this.setSegnaTempo(LocalTime.now());
    }

    public void iniziaMossa() {
        this.mossaCorrente++;
        this.setSegnaTempo(LocalTime.now());
    }
    
}
