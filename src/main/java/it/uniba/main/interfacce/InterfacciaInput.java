/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import java.util.Scanner;
import it.uniba.main.Damiera;
import it.uniba.main.Help;
import it.uniba.main.Partita;

/**
 *
 * @author giuse
 */
public class InterfacciaInput {

    public static boolean chiediConferma(String richiesta, String casoAffermativo, String casoNegativo) {
        boolean vuole = false;

        System.out.println(richiesta);
        boolean error;
        String answer;

        Scanner sc = new Scanner(System.in);
        do {
            error = false;
            System.out.println("digitare 'si' o 'no'.");
            if (sc.hasNextLine()) {
                answer = sc.nextLine();
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
        } while (error == true);

        return vuole;
    }

    public static void menuDiInizio() {
        boolean isExiting = false;
        String answer;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("-------------------------------- Menu Principale --------------------------------");
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
                        Partita.azzeraPartitaCorrente();
                        break;
                    case "numeri":
                        Damiera.getDamiera().stampaNumeri();
                        break;
                    case "esci":
                        isExiting = InterfacciaInput.chiediConferma("Si vuole davvero uscire?", "Alla prossima partita!", "Non si è usciti dal gioco.");
                        break;
                    case "damiera":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. Digitare gioca per avviare una nuova partita.");
                        break;
                    case "abbandona":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. Digitare gioca per avviare una nuova partita.");
                        break;
                    case "tempo":
                        System.out.println("Questo comando è eseguibile solo a partita avviata. Digitare gioca per avviare una nuova partita.");
                        break;
                    default:
                        System.out.println("Comando inserito non valido.");
                        System.out.println("Per sapere quali comandi sono validi digitare help.");
                        break;
                }
            }
        } while (isExiting == false);

        sc.close();
    }
}
