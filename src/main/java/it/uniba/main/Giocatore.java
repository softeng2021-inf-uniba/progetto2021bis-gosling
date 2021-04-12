/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.types.Colore;
import java.time.LocalTime;
import java.util.Scanner;

/**
 *
 * @author domenico francesco e giuseppe
 */
public class Giocatore {

    /* ------------ Stato ------------ */
    private String nome;
    private Colore colore;
    private LocalTime tempoInizioMossa;
    private LocalTime tempoFineMossa;
    private LocalTime tempoRimanente;
    private int mossaCorrente;
    private static final int MIN_LUN_NOME = 3;
    private static final int MAX_LUN_NOME = 20;

    /* ------------ Costruttori ------------ */
    Giocatore(int index) {
        this.scegliNome(index);
        this.scegliColore();
        this.tempoInizioMossa = null;
        this.tempoFineMossa = null;
        this.tempoRimanente = null;
        this.mossaCorrente = 0;
    }

    Giocatore(int index, Colore colore) {
        this.scegliNome(index);
        this.colore = colore;
        this.tempoInizioMossa = null;
        this.tempoFineMossa = null;
        this.tempoRimanente = null;
        this.mossaCorrente = 0;
    }

    /* ------------ Get & Set ------------ */
    public void setColore(Colore colore) {
        this.colore = colore;
    }

    public Colore getColore() {
        return (this.colore);
    }

    public Colore getColoreAvversario() {

        Colore coloreAvversario = null;

        if (this.getColore() == Colore.bianco) {
            coloreAvversario = Colore.nero;
        } else {
            coloreAvversario = Colore.bianco;
        }

        return (coloreAvversario);
    }

    public void setTempoInizioMossa(LocalTime tempoInizioMossa) {
        this.tempoInizioMossa = tempoInizioMossa;
    }

    public LocalTime getTempoInizioMossa() {
        return (this.tempoInizioMossa);
    }

    public void setTempoFineMossa(LocalTime tempoFineMossa) {
        this.tempoFineMossa = tempoFineMossa;
    }

    public LocalTime getTempoFineMossa() {
        return (this.tempoFineMossa);
    }

    public LocalTime getTempoRimanente() {
        return (this.tempoRimanente);
    }

    public LocalTime getTempoPassato() {
        LocalTime tempoPassato = LocalTime.now();
        return (tempoPassato);
    }

    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    private void scegliColore() {

        boolean errore;

        do {
            errore = false;

            System.out.println(this.nome + ", scelga il suo colore: digiti \"bianco\" o \"nero\"");
            Scanner scanner = new Scanner(System.in);
            String input = null;

            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }

            /*Elimino gli eventuali spazi*/
            input = input.replaceAll(" +", "");

            switch (input.toLowerCase()) {

                case "bianco":
                    this.colore = Colore.bianco;
                    break;
                case "nero":
                    this.colore = Colore.nero;
                    break;
                default:
                    errore = true;
            }

            if (errore) {
                System.out.println("Comando non riconosciuto. Inserire un comando valido");
            }

        } while (errore);
    }

    private void scegliNome(int index) {

        boolean errore;

        do {
            errore = false;

            System.out.println("Scegliere il nome del giocatore " + index);
            Scanner scanner = new Scanner(System.in);
            String input = null;

            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }

            /*Elimino gli eventuali spazi*/
            input = input.replaceAll(" +", "");

            if (input.length() < MIN_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di almeno " + MIN_LUN_NOME + " caratteri");
            }

            if (input.length() > MAX_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di, al massimo, " + MAX_LUN_NOME +  " caratteri");
            }

            for (char cha : input.toCharArray()) {
                if (!Character.isLetter(cha) && !Character.isDigit(cha)) {
                    errore = true;
                    System.out.println("Puoi inserire solo lettere e numeri");
                    break;
                }
            }

            this.nome = input;

        } while (errore);
    }

    private void incrementaMossaCorrente() {
        this.mossaCorrente++;
    }

    public void iniziaMossa() {
        this.incrementaMossaCorrente();
        this.setTempoInizioMossa(LocalTime.now());
    }

}
