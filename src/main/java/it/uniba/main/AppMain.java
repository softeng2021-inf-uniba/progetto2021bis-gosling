package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import it.uniba.sotorrent.GoogleDocsUtils;
import java.util.Scanner;
import it.uniba.main.Pedina;

/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

    /**
     * Private constructor. Change if needed.
     */
    private AppMain() {

    }

    /**
     * 	 * This is the main entry of the application.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {

        System.out.println("Benvenuto nell'applicazione di Dama!");

        if (args.length > 0) {
            switch (args[0]) {
                case "--help":
                case "-h":
                    Help.getMenuHelp();
                    break;
                default:
                    break;
            }
        }

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
                        Pedina.setInvertiColore(vuoleInvertitireColori());
                        Partita.nuovaPartita();
                        Partita.azzeraPartitaCorrente();
                        break;
                    case "numeri":
                        Damiera.getDamiera().stampaNumeri();
                        break;
                    case "esci":
                        isExiting = vuoleUscire();
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
        
        System.exit(0);
    }

    public static boolean vuoleUscire() {

        boolean vuoleUscire = false;

        System.out.println("Sicuro di voler uscire dal gioco?");
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
                        System.out.println("Alla prossima partita!");
                        vuoleUscire = true;
                        break;
                    case "no":
                        System.out.println("Non sei uscito dal gioco.");
                        break;
                    default:
                        System.out.println("Digitare un comando valido...");
                        error = true;
                        break;
                }
            }
        } while (error == true);

        return vuoleUscire;
    }
    
    public static boolean vuoleInvertitireColori()
    {
        boolean vuoleInvertire = false;

        System.out.println("È consigliato, se si è su sfondo nero, di invertire i colori delle pedine.");
        System.out.println("Invertire i colori delle pedine?");
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
                        System.out.println("I colori verranno invertiti.");
                        vuoleInvertire = true;
                        break;
                    case "no":
                        System.out.println("I colori non verranno invertiti.");
                        break;
                    default:
                        System.out.println("Digitare un comando valido...");
                        error = true;
                        break;
                }
            }
        } while (error == true);

        return vuoleInvertire;
    }
}
