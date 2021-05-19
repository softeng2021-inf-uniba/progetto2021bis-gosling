/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;
import java.util.Scanner;
import it.uniba.main.Damiera;
import it.uniba.main.Giocatore;
import it.uniba.main.Help;
import it.uniba.main.Partita;
import it.uniba.main.eccezioni.eccezionePresa;
import it.uniba.main.eccezioni.eccezioneSpostamento;
import java.util.HashSet;
import java.util.Set;

/**
 * Tipo Classe: <<Boundary>>
 *
 * Gestisce la comunicazione tra l'applicazione e l'input utente. Contiene il
 * "parser" che controlla se i comandi inseriti sono corretti e chiama le
 * funzionalità collegate.
 *
 */
public final class InterfacciaInput {
    private InterfacciaInput() {
    }
    public static boolean chiediConferma(final String richiesta, final String casoAffermativo,
            final String casoNegativo) {
        boolean vuole = false;

        System.out.println(richiesta);
        boolean error;
        String answer;

        Scanner sc = new Scanner(System.in, "utf-8");
        do {
            error = false;
            System.out.println("digitare 'si' o 'no'.");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                System.out.println(answer);
                answer = answer.replaceAll(" +", "");
                switch (answer.toLowerCase()) {
                    case "si":
                    case "sì":
                        System.out.println(casoAffermativo);
                        vuole = true;
                        break;
                    case "no":
                        System.out.println(casoNegativo);
                        break;
                    default:
                        System.out.println("Digitare una risposta valida...");
                        error = true;
                        break;
                }
            }
        } while (error);

        return vuole;
    }

    public static void menuDiInizio() {
        boolean isExiting = false;
        String answer;
        Scanner sc = new Scanner(System.in, "utf-8");

        do {
            System.out.println("-------------------------------- Menu Principale "
                    + "--------------------------------");
            System.out.println("Digitare un comando valido... (digita 'help' per visualizzare i comandi)");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                answer = answer.replaceAll(" +", "");
                switch (answer.toLowerCase()) {
                    case "help":
                        Help.getMenuHelp();
                        break;
                    case "gioca":
                        Partita.nuovaPartita();
                        Partita.getPartita().giocaPartita();
                        Partita.azzeraPartitaCorrente();
                        break;
                    case "numeri":
                        Damiera.getDamiera().stampaNumeri();
                        break;
                    case "esci":
                        isExiting = InterfacciaInput.chiediConferma("Si vuole davvero uscire?",
                                "Alla prossima partita!", "Non si è usciti dal gioco.");
                        break;
                    case "damiera":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. "
                                + "Digitare gioca per avviare una nuova partita.");
                        break;
                    case "abbandona":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. "
                                + "Digitare gioca per avviare una nuova partita.");
                        break;
                    case "tempo":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. "
                                + "Digitare gioca per avviare una nuova partita.");
                        break;
                    case "prese":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. "
                                + "Digitare gioca per avviare una nuova partita.");

                        break;
                    case "mosse":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. "
                                + "Digitare gioca per avviare una nuova partita.");
                        break;

                    default:
                        System.out.println("Comando inserito non valido.");
                        System.out.println("Per sapere quali comandi sono validi digitare help.");
                        break;
                }
            }
        } while (!isExiting);

        sc.close();
    }

    public static void menuDiGico(final Giocatore corrente, final Giocatore avversario) {
        boolean isExiting = false;
        String answer;

        corrente.iniziaMossa();

        Scanner sc = new Scanner(System.in, "utf-8");
        do {
            System.out.println("Digitare un comando valido...");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
                answer = answer.replaceAll("\\s+", "");
                switch (answer.toLowerCase()) {
                    case "help":
                        Help.getMenuHelp();
                        break;
                    case "numeri":
                        Damiera.getDamiera().stampaNumeri();
                        break;
                    case "damiera":
                        Damiera.getDamiera().stampaPedine();
                        break;
                    case "tempo":
                        Partita.getPartita().stampaTempoPassato();
                        break;
                    case "abbandona":
                        isExiting = InterfacciaInput.chiediConferma("Sicuro di voler abbandonare? L'avversario "
                                + "vincerà in caso affermativo.", "Partita abbandonata.", "Partita non abbandonata.");

                        if (isExiting) {
                            System.out.println(corrente.getNome() + " (" + corrente.getColore().toString() + ")"
                                    + " ha abbandonato il gioco.");
                            System.out.println(avversario.getNome() + " (" + avversario.getColore().toString()
                                    + ")" + " ha vinto per abbandono.");
                            Partita.getPartita().finisciPartita();
                        }

                        break;
                    case "prese":
                        Damiera.getDamiera().stampaPedineMangiate();
                        break;
                    case "mosse":
                        Damiera.getDamiera().stampaMosse();
                        break;
                    default:
                        if (sintassiSpostamentoCorretta(answer)) {
                            try {
                                isExiting = Damiera.getDamiera().spostamentoPedina(answer, corrente.getColore());
                            }catch(eccezioneSpostamento exc) {
                                System.out.println(exc.getMessage());
                            } finally {
                                if (isExiting) {
                                    Damiera.getDamiera().registraMosse(answer, corrente.getColore());
                                }
                            }
                        } else if (sintassiPresaSempliceCorretta(answer)) {
                            try { // Esegui 
                                isExiting = Damiera.getDamiera().effettuaPresaSemplice(answer, corrente.getColore());
                            }catch(eccezionePresa exc){ // se ti da errore stampalo e metti a false isExiting
                                System.out.println(exc.getMessage());
                                isExiting= false;
                            } finally { // alla fine controlla
                                if(isExiting) {
                                    Damiera.getDamiera().registraMosse(answer, corrente.getColore());
                                }
                            }
                        } else if (sintassiPresaMultiplaCorretta(answer)) {
                            try { // Esegui 
                                isExiting = Damiera.getDamiera().effettuaPresaMultipla(answer, corrente.getColore());
                            }catch(eccezionePresa exc){ // se ti da errore stampalo e metti a false isExiting
                                System.out.println(exc.getMessage());
                                isExiting= false;
                            } finally { // alla fine controlla
                                if(isExiting) {
                                    Damiera.getDamiera().registraMosse(answer, corrente.getColore());
                                } 
                            }
                        } else {
                            System.out.println("Comando inserito non valido.");
                            System.out.println("Per sapere quali comandi sono validi digitare help.");
                        }
                        break;
                }
            }
        } while (!isExiting);
    }

    public static boolean sintassiSpostamentoCorretta(final String answer) {
        boolean sintassiCorretta = false;
        if (answer.matches("[1-9][0-9]?-[0-9][0-9]?")) {
            String[] numeri = answer.split("-");
            int num1 = Integer.parseInt(numeri[0]);
            int num2 = Integer.parseInt(numeri[1]);
            boolean primoCorretto = (num1 >= 1) && (num1 <= Damiera.getGrandezzaPosizioni());
            boolean secondoCorretto = (num2 >= 1) && (num2 <= Damiera.getGrandezzaPosizioni()) && (num1 != num2);
            if (primoCorretto && secondoCorretto) {
                sintassiCorretta = true;
            }
        }
        return sintassiCorretta;
    }

    public static boolean sintassiPresaSempliceCorretta(final String answer) {
        boolean sintassiCorretta = false;

        if (answer.matches("[1-9][0-9]?x[0-9][0-9]?")) {
            String[] numeri = answer.split("x");
            int num1 = Integer.parseInt(numeri[0]);
            int num2 = Integer.parseInt(numeri[1]);
            boolean primoCorretto = (num1 >= 1) && (num1 <= Damiera.getGrandezzaPosizioni());
            boolean secondoCorretto = (num2 >= 1) && (num2 <= Damiera.getGrandezzaPosizioni()) && (num1 != num2);
            if (primoCorretto && secondoCorretto) {
                sintassiCorretta = true;
            }
        }

        return sintassiCorretta;
    }

    public static boolean sintassiPresaMultiplaCorretta(final String answer) {
        boolean sintassiCorretta = false;
        boolean sameNumber = false;
        boolean nonNumber = false;
        if (answer.matches("[1-9][0-9]?(x[0-9][0-9]?)+")) {
            String[] numeri = answer.split("x");
            Set<Integer> values = new HashSet<>();
            for (String s : numeri) {
                int value = Integer.parseInt(s);
                if (value >= 1 && value <= Damiera.getGrandezzaPosizioni()) {
                    if (values.contains(value)) {
                        sameNumber = true;

                    } else {
                        values.add(value);
                    }
                } else {
                    nonNumber = true;
                }
            }
            if (sameNumber || nonNumber) {
                System.out.println("Numeri inseriti non validi");
                sintassiCorretta = false;
            } else {
                sintassiCorretta = true;
            }

        }

        return sintassiCorretta;
    }
}
