package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import it.uniba.sotorrent.GoogleDocsUtils;
import it.uniba.main.interfacce.InterfacciaInput;

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

        InterfacciaInput.menuDiInizio();
        
        System.exit(0);
    }
}
