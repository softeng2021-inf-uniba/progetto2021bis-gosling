/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import java.util.Scanner;

/**
 *
 * @author giuse
 */
public class InterfacciaInput {
    
    public static boolean chiediConferma(String richiesta, String casoAffermativo, String casoNegativo)
    {
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
    
}
