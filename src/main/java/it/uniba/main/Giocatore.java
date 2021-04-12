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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author domenico francesco e giuseppe
 */
public class Giocatore {

    /* ------------ Stato ------------ */
    private String nome;
    private Colore colore;
    private LocalTime tempoInizioMossa;
    private LocalTime tempoPassato;
    private int mossaCorrente;
    private static final int MIN_LUN_NOME = 3;
    private static final int MAX_LUN_NOME = 20;
    private static final LocalTime TEMPO_DISP = LocalTime.of(0, 30, 0);

    /* ------------ Costruttori ------------ */
    Giocatore() {
        this.scegliNome();
        this.scegliColore();
        this.tempoInizioMossa = null;
        this.tempoPassato = LocalTime.of(0, 0, 0);
        this.mossaCorrente = 0;
    }

    Giocatore(String nomeVietato, Colore colore) {
        this.scegliNome(nomeVietato);
        this.colore = colore;
        this.tempoInizioMossa = null;
        this.tempoPassato = LocalTime.of(0, 0, 0);
        this.mossaCorrente = 0;
    }

    /* ------------ Get & Set ------------ */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

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

    public LocalTime getTempoPassato() {
        return this.tempoPassato;
    }

    public int getMossaCorrente() {
        return (this.mossaCorrente);
    }

    /* ------------ Metodi ------------ */
    public void aggiornaTempoPassato()
    {
        LocalTime now = LocalTime.now();
        
        Long minutes = MINUTES.between(tempoInizioMossa, now);
        Long seconds = SECONDS.between(tempoInizioMossa, now) % 60;
        
        this.tempoPassato.plusMinutes(minutes);
        this.tempoPassato.plusSeconds(seconds);
    }
    
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
                System.out.println("Comando non riconosciuto. Inserire un comando valido.");
            }

        } while (errore);
    }

    private void scegliNome() {

        boolean errore;

        System.out.println("Scegliere il nome del giocatore 1.");
        System.out.println("Il nome deve avere un numero di caratteri compreso "
                + "tra 3 e 20, estremi inclusi, e può contenere solo numeri e "
                + "lettere.");

        do {
            errore = false;

            Scanner scanner = new Scanner(System.in);
            String input = null;

            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }

            /*Elimino gli eventuali spazi*/
            input = input.replaceAll(" +", "");

            if (input.length() < MIN_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di almeno " + MIN_LUN_NOME + " caratteri.");
            }

            if (input.length() > MAX_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di, al massimo, " + MAX_LUN_NOME + " caratteri.");
            }

            for (char cha : input.toCharArray()) {
                if (!Character.isLetter(cha) && !Character.isDigit(cha)) {
                    errore = true;
                    System.out.println("Puoi inserire solo lettere e numeri.");
                    break;
                }
            }

            this.nome = input;

        } while (errore);
    }

    private void scegliNome(String nomeVietato) {

        boolean errore;

        System.out.println("Scegliere il nome del giocatore 2.");
        System.out.println("Il nome deve avere un numero di caratteri compreso "
                + "tra 3 e 20, estremi inclusi, e può contenere solo numeri e "
                + "lettere.");

        do {
            errore = false;

            Scanner scanner = new Scanner(System.in);
            String input = null;

            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
            }

            /*Elimino gli eventuali spazi*/
            input = input.replaceAll(" +", "");

            if (input.length() < MIN_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di almeno " + MIN_LUN_NOME + " caratteri.");
            }

            if (input.length() > MAX_LUN_NOME) {
                errore = true;
                System.out.println("Inserire un nome di, al massimo, " + MAX_LUN_NOME + " caratteri.");
            }

            for (char cha : input.toCharArray()) {
                if (!Character.isLetter(cha) && !Character.isDigit(cha)) {
                    errore = true;
                    System.out.println("Puoi inserire solo lettere e numeri.");
                    break;
                }
            }

            if (input.compareToIgnoreCase(nomeVietato) == 0) {
                System.out.println("Il nome " + nomeVietato + " è già stato preso dal giocatore 1.");
                errore = true;
            }

            this.nome = input;

        } while (errore);
    }

    public void iniziaMossa() {
        this.mossaCorrente++;
        this.setTempoInizioMossa(LocalTime.now());
    }
}
