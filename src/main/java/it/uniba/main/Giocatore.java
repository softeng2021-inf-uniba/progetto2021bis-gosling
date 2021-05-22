/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * Tipo Classe: <<Entity>>
 *
 * Contiene le informazioni relative al gicoatore come il colore e il tempo
 * passato
 *
 */
public final class Giocatore {

    /* ------------ Stato ------------ */
    private String nome;
    private Pedina.Colore colore;
    private LocalTime segnaTempo;
    private LocalTime tempoPassato;
    private int mossaCorrente;

    /* ------------ Costruttori ------------ */
    public Giocatore(final int index) {

        switch (index) {
            case 1:
                this.setNome("Giocatore 1");
                this.setColore(Pedina.Colore.bianco);
                break;
            case 2:
                this.setNome("Giocatore 2");
                this.setColore(Pedina.Colore.nero);
                break;
            default:
                this.setNome("Giocatore 2");
                this.setColore(Pedina.Colore.nero);
                break;
        }

        this.segnaTempo = LocalTime.of(0, 0, 0);
        this.tempoPassato = LocalTime.of(0, 0, 0);
        this.mossaCorrente = 0;
    }

    /* ------------ Get & Set ------------ */
    private void setNome(final String nomeIn) {
        this.nome = nomeIn;
    }

    public String getNome() {
        return this.nome;
    }

    private void setColore(final Pedina.Colore coloreIn) {
        this.colore = coloreIn;
    }

    public Pedina.Colore getColore() {
        return (this.colore);
    }

    public Pedina.Colore getColoreAvversario() {

        Pedina.Colore coloreAvversario;

        if (this.getColore() == Pedina.Colore.bianco) {
            coloreAvversario = Pedina.Colore.nero;
        } else {
            coloreAvversario = Pedina.Colore.bianco;
        }

        return (coloreAvversario);
    }

    private void setSegnaTempo(final LocalTime tempoUltimoAggiornamento) {
        this.segnaTempo = tempoUltimoAggiornamento;
    }

    public LocalTime getTempoPassato() {
        return this.tempoPassato;
    }

    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    public void aggiornaTempoPassato() {
        final int secondi = 60;
        LocalTime now = LocalTime.now();
        Long minutes = MINUTES.between(segnaTempo, now);
        Long seconds = SECONDS.between(segnaTempo, now) % secondi;
        this.tempoPassato = this.tempoPassato.plusMinutes(minutes);
        this.tempoPassato = this.tempoPassato.plusSeconds(seconds);
        this.setSegnaTempo(LocalTime.now());
    }

    public void iniziaMossa() {
        this.mossaCorrente++;
        this.setSegnaTempo(LocalTime.now());
    }

}
