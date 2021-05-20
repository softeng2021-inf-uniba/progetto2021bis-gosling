/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import it.uniba.main.Giocatore;
import it.uniba.main.Partita;
import static it.uniba.main.interfacce.InterfacciaInput.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
        PrintStream backupOut = System.out;

        String commandSequence = "22-18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(!outContent.toString().contains("Comando inserito non valido."));
        
        Partita.azzeraPartitaCorrente();
    }   
    
            
    @Test
    void testMenuDiGioco_spostamentoErrato() {
        PrintStream backupOut = System.out;

        String commandSequence = "18-13" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Casella di partenza vuota"));
        
        Partita.azzeraPartitaCorrente();
    }
           
    @Disabled
    @Test
    void testMenuDiGioco_presaSempliceCorretta() {
        PrintStream backupOut = System.out;

        String commandSequence = "22-18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(!outContent.toString().contains("Comando inserito non valido."));
        
        Partita.azzeraPartitaCorrente();
    }   
    
    @Test
    void testMenuDiGioco_presaSempliceErrata() {
        PrintStream backupOut = System.out;

        String commandSequence = "18x13" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Presa non valida. La casella di partenza è vuota"));
        
        Partita.azzeraPartitaCorrente();
    }   
               
    @Disabled
    @Test
    void testMenuDiGioco_presaMultiplaCorretta() {
        PrintStream backupOut = System.out;

        String commandSequence = "22-18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(!outContent.toString().contains("Comando inserito non valido."));
        
        Partita.azzeraPartitaCorrente();
    }   
    
    @Test
    void testMenuDiGioco_presaMultiplaErrata() {
        PrintStream backupOut = System.out;

        String commandSequence = "18x13x9" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();
        
        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Presa non valida. La casella di partenza è vuota"));
        
        Partita.azzeraPartitaCorrente();
    }   
    
    @Test
    void testMenuDiGioco_presaMultiplaErrataStessaCaselle() {
        PrintStream backupOut = System.out;

        String commandSequence = "18x18x18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Numeri inseriti non validi"));

        Partita.azzeraPartitaCorrente();
    }
        
    @Test
    void testMenuDiGioco_presaMultiplaErrataNumeriGrandi() {
        PrintStream backupOut = System.out;

        String commandSequence = "55x55x55" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Partita.nuovaPartita();
        Partita partita = Partita.getPartita();

        menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());

        System.setOut(backupOut);

        assertTrue(outContent.toString().contains("Numeri inseriti non validi"));

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
}
