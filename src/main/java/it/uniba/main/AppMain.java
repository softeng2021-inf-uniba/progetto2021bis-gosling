package it.uniba.main;

import it.uniba.main.interfacce.InterfacciaInput;
import it.uniba.main.interfacce.Help;
/**
 * Tipo classe: <<Control>>
 *
 * Accetta parametri di avvio e avvia l'applicazione. Chiama l'oggetto di interfaccia.
 * 
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
                    Help.stampaHelpMenu();
                    break;
                default:
                    break;
            }
        }

        InterfacciaInput.setInputStream(System.in);
        InterfacciaInput.menuDiInizio();
        System.exit(0);
    }
}
