package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import it.uniba.sotorrent.GoogleDocsUtils;
import java.util.Scanner;

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
                System.out.println("Per sapere quali comandi sono validi digitare help");
                boolean isExiting = false; 
                String answer;
                Scanner sc = new Scanner(System.in);
                do
                {
                    System.out.println("Digitare un comando valido...");
                    if(sc.hasNextLine())
                    {
                        answer = sc.nextLine();
                        switch(answer)
                        {
                            case "help":
                                Help.getMenuHelp();
                                break;
                            case "numeri":
                                Damiera.getDamiera().stampaNumeri();
                                break;
                            //va inserito gioca
                            // va inserito esci
                            default:
                                System.out.println("Comando inserito non valido");
                                System.out.println("Per sapere quali comandi sono validi digitare help");
                                break;
                        } 
                    }          
                }while(isExiting==false);
                sc.close();
	}

}
