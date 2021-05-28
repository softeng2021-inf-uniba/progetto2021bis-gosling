/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.dati;

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
    /**
     *  Nome del giocatore
     */
    private String nome;
    /**
     *  Colore del giocatore
     */
    private Pedina.Colore colore;
    /**
     *  Attributo che serve per segnare il tempo passato
     */
    private LocalTime segnaTempo;
    /**
     * Indica il tempo trascorso nei turni del giocatore
     */
    private LocalTime tempoPassato;
    /**
     * Il numero della mossa correntemente in vigore
     */
    private int mossaCorrente;

    /* ------------ Costruttori ------------ */
    /**
     * Costruttore pubblico di giocatore.
     * @param index e' l'indice del giocatore. 1 Corrisponde al giocatore 1, e al
     * bianco, 2 corrisponde al giocatore 2, cioe' al nero
     */
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
    /**
     * Set del nome.
     * @param nomeIn e' il nome del giocatore che si vuole impostare
     */
    private void setNome(final String nomeIn) {
        this.nome = nomeIn;
    }
    /**
     * Restituisce il nome corrente.
     * @return nome del giocatore
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Set del colore del giocatore.
     * @param coloreIn e' il colore che si vuole impostare
     */
    private void setColore(final Pedina.Colore coloreIn) {
        this.colore = coloreIn;
    }
    /**
     * Restituisce il colore del giocatore corrente.
     * @return colore del giocatore
     */
    public Pedina.Colore getColore() {
        return (this.colore);
    }
    /**
     * Restituisce il colore dell'avversario.
     * @return Nero se l'attuale giocatore e' Bianco, Bianco altrimenti
     */
    public Pedina.Colore getColoreAvversario() {

        Pedina.Colore coloreAvversario;

        if (this.getColore() == Pedina.Colore.bianco) {
            coloreAvversario = Pedina.Colore.nero;
        } else {
            coloreAvversario = Pedina.Colore.bianco;
        }

        return (coloreAvversario);
    }
    /**
     * Avvia il segna tempo.
     * @param tempoUltimoAggiornamento e' il nuovo tempo dal quale parte il conteggio
     */
    private void setSegnaTempo(final LocalTime tempoUltimoAggiornamento) {
        this.segnaTempo = tempoUltimoAggiornamento;
    }
    /**
     * Restituisce il tempo passato.
     * @return Il tempo passato
     */
    public LocalTime getTempoPassato() {
        return this.tempoPassato;
    }
    /**
     * Restituisce l'intero che rappresenta la mossa corrente.
     * @return Il numero della mossa corrente
     */
    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    /**
     *  Aggiorna il tempo passato dal segnaTempo al momento attuale.
     */
    public void aggiornaTempoPassato() {
        final int secondi = 60;
        LocalTime now = LocalTime.now();
        Long minutes = MINUTES.between(segnaTempo, now);
        Long seconds = SECONDS.between(segnaTempo, now) % secondi;
        this.tempoPassato = this.tempoPassato.plusMinutes(minutes);
        this.tempoPassato = this.tempoPassato.plusSeconds(seconds);
        this.setSegnaTempo(LocalTime.now());
    }
    /**
     * Da il via al turno, iniziato il timer e aumentando la mossa corrente.
     */
    public void iniziaMossa() {
        this.mossaCorrente++;
        this.setSegnaTempo(LocalTime.now());
    }

}
