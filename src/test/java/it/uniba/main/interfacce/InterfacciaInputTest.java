/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import it.uniba.main.Damiera;
import it.uniba.main.Giocatore;
import it.uniba.main.Partita;
import static it.uniba.main.interfacce.InterfacciaInput.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author mtubi
 */
public class InterfacciaInputTest {

    @BeforeEach
    void setUp() {
        InterfacciaInput.setInputStream(System.in);
    }

    @Test
    void testChiediConferma_affermativo() {

        String sequenzaDiComandi = "si";
        ByteArrayInputStream in = new ByteArrayInputStream(sequenzaDiComandi.getBytes());

        InterfacciaInput.setInputStream(in);
        assertTrue(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
    }

    @Test
    void testChiediConferma_negativo() {

        String sequenzaDiComandi = "no";
        ByteArrayInputStream in = new ByteArrayInputStream(sequenzaDiComandi.getBytes());

        InterfacciaInput.setInputStream(in);
        assertFalse(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
    }

    @Test
    void testChiediConferma_inputErrato() {

        String sequenzaDiComandi = "errato" + System.lineSeparator() + "si";
        ByteArrayInputStream in = new ByteArrayInputStream(sequenzaDiComandi.getBytes());

        InterfacciaInput.setInputStream(in);
        assertTrue(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
    }

    @Test
    void testMenuDiInizio_help() {
        PrintStream backupOut = System.out;

        String commandSequence = "help" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("HELP"));
    }

    @Test
    void testMenuDiInizio_gioca() {
        PrintStream backupOut = System.out;

        String commandSequence = "gioca" + System.lineSeparator() + "abbandona" + System.lineSeparator()
                + "si" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("La partita inizia ora"));
    }

    @Test
    void testMenuDiInizio_numeri() {
        PrintStream backupOut = System.out;

        String commandSequence = "numeri" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("+---+---+---+---+---+---+---+---+"));
    }

    @Test
    void testMenuDiInizio_damiera() {
        PrintStream backupOut = System.out;

        String commandSequence = "damiera" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Questo comando è eseguibile solo a partita avviata."));
    }

    @Test
    void testMenuDiInizio_abbandona() {
        PrintStream backupOut = System.out;

        String commandSequence = "abbandona" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Questo comando è eseguibile solo a partita avviata."));
    }

    @Test
    void testMenuDiInizio_tempo() {
        PrintStream backupOut = System.out;

        String commandSequence = "tempo" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Questo comando è eseguibile solo a partita avviata."));
    }

    @Test
    void testMenuDiInizio_prese() {
        PrintStream backupOut = System.out;

        String commandSequence = "prese" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Questo comando è eseguibile solo a partita avviata."));
    }

    @Test
    void testMenuDiInizio_mosse() {
        PrintStream backupOut = System.out;

        String commandSequence = "mosse" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Questo comando è eseguibile solo a partita avviata."));
    }

    @Test
    void testMenuDiInizio_comandoErrato() {
        PrintStream backupOut = System.out;

        String commandSequence = "comando errato" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        menuDiInizio();

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Comando inserito non valido."));
    }

    @Test
    void testMenuDiGioco_help() {
        PrintStream backupOut = System.out;

        String commandSequence = "help" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("HELP"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_numeri() {
        PrintStream backupOut = System.out;

        String commandSequence = "numeri" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("+---+---+---+---+---+---+---+---+"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_damiera() {
        PrintStream backupOut = System.out;

        String commandSequence = "damiera" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("+---+---+---+---+---+---+---+---+"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_tempo() {
        PrintStream backupOut = System.out;

        String commandSequence = "tempo" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Il tempo di gioco di"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_abbandona() {
        PrintStream backupOut = System.out;

        String commandSequence = "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("ha abbandonato il gioco"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_prese() {
        PrintStream backupOut = System.out;

        String commandSequence = "prese" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Nero:") && outContent.toString().contains("Bianco:"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_mosse() {
        PrintStream backupOut = System.out;

        String commandSequence = "mosse" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Lista mosse:"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_spostamentoCorretto() {
        String commandSequence = "22-18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 22-18"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_spostamentoErrato() {
        String commandSequence = "18-13" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18-13"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_presaSempliceCorretta() {
        String commandSequence = "21-18" + System.lineSeparator() + "9-13" 
                + System.lineSeparator() + "18x9" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 18x9"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_presaSempliceErrata() {
        String commandSequence = "18x8" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18x8"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_presaMultiplaCorretta() {
        String commandSequence = "22-18" + System.lineSeparator() + "11-15" + System.lineSeparator() + "21-17"
                 + System.lineSeparator() + "12-16"  + System.lineSeparator() + "26-21"  + System.lineSeparator() + "8-12"
                 + System.lineSeparator() + "29-26"  + System.lineSeparator() + "4-8"  + System.lineSeparator() + "24-20"
                 + System.lineSeparator() + "10-14" + System.lineSeparator() + "18x11x4"  + System.lineSeparator() + "abbandona"
                 + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 18x11x4"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_presaMultiplaErrata() {
        String commandSequence = "18x13x10" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        Partita.nuovaPartita();
        Partita.getPartita().giocaPartita();
        
        assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18x13x10"));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testMenuDiGioco_comandoErrato() {
        PrintStream backupOut = System.out;

        String commandSequence = "comando errato" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Comando inserito non valido."));

        Partita.azzeraPartitaCorrente();
    }

    @Test
    void testSintassiPresaMultiplaCorretta_errataStessaCaselle() {
        String mossa = "18x18x18";
        assertFalse(sintassiPresaMultiplaCorretta(mossa));
    }

    @Test
    void testSintassiPresaMultiplaCorretta_errataNumeriSbagliati() {
        String mossa = "55x55x55";
        assertFalse(sintassiPresaMultiplaCorretta(mossa));
    }
}
