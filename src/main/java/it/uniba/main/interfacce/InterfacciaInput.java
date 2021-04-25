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
                        Partita.getPartita().giocaPartita();
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
    
     public static void menuDiGico(Giocatore corrente, Giocatore avversario) {
        boolean isExiting = false;
        String answer;

        corrente.iniziaMossa();

        Scanner sc = new Scanner(System.in);
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
                        isExiting = InterfacciaInput.chiediConferma("Sicuro di voler abbandonare? L'avversario vincerà in caso affermativo.", "Partita abbandonata.", "Partita non abbandonata.");

                        if (isExiting) {
                            System.out.println(corrente.getNome() + " (" + corrente.getColore().toString() + ")" + " ha abbandonato il gioco.");
                            System.out.println(avversario.getNome() + " (" + avversario.getColore().toString() + ")" + " ha vinto per abbandono.");
                            Partita.getPartita().finisciPartita();
                        }
                        
                        break;
                    default:
                        if(sintassiMossaCorretta(answer)){
                           if(Damiera.getDamiera().spostaPedina(answer)){
                               System.out.println("Mossa eseguita");
                           }
                        }
                        else{
                        System.out.println("Comando inserito non valido.");
                        System.out.println("Per sapere quali comandi sono validi digitare help.");
                        }
                        break;
                }
            }
        } while (isExiting == false);
    }
     
     public static boolean sintassiMossaCorretta(String answer){
         boolean corretto=false;
         if(answer.matches("[1-9][0-9]?-[0-9][0-9]?")){
             String[] numeri = answer.split("-");
             int num1 = Integer.valueOf(numeri[0]);
             int num2 = Integer.valueOf(numeri[1]);
             boolean primoCorretto = (num1 >= 1)&&(num1 <= 32);
             boolean secondoCorretto = (num2 >= 1)&&(num2 <= 32) && (num1 != num2);
             if(primoCorretto && secondoCorretto){
                 corretto = true;
             }
         }
         return corretto;
     }
}


