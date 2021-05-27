/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import it.uniba.main.dati.Damiera;
import it.uniba.main.dati.Partita;
import static it.uniba.main.interfacce.InterfacciaInput.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "si";
            in = new ByteArrayInputStream(sequenzaDiComandi.getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            assertTrue(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testChiediConferma_negativo() {

        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "no";
            in = new ByteArrayInputStream(sequenzaDiComandi.getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            assertFalse(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testChiediConferma_inputErrato() {

        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "errato" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream(sequenzaDiComandi.getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            assertTrue(chiediConferma("Domanda", "Caso affermativo", "Caso negativo"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_help() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "help" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("HELP"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_gioca() {
        ByteArrayInputStream in = null;
        try {
            PrintStream backupOut = System.out;
            String sequenzaDiComandi = "gioca" + System.lineSeparator() + "abbandona" + System.lineSeparator()
                    + "si" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            menuDiInizio();
            System.setOut(backupOut);
            assertTrue(outContent.toString("utf-8").contains("La partita inizia ora"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_numeri() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "numeri" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("+---+---+---+---+---+---+---+---+"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_damiera() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "damiera" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Questo comando è eseguibile solo a partita avviata"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_abbandona() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "abbandona" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Questo comando è eseguibile solo a partita avviata"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_tempo() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "tempo" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Questo comando è eseguibile solo a partita avviata"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_prese() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "prese" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Questo comando è eseguibile solo a partita avviata"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_mosse() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "mosse" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Questo comando è eseguibile solo a partita avviata"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiInizio_comandoErrato() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "comando errato" + System.lineSeparator() + "esci" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            menuDiInizio();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Comando inserito non valido"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_help() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "help" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("HELP"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_numeri() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "numeri" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("+---+---+---+---+---+---+---+---+"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_damiera() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "damiera" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("+---+---+---+---+---+---+---+---+"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_tempo() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "tempo" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Il tempo di gioco di"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_abbandona() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("ha abbandonato il gioco"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_prese() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "prese" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Nero:") && outContent.toString("utf-8").contains("Bianco:"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_mosse() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "mosse" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Lista mosse:"));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_spostamentoCorretto() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "22-18" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 22-18"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_spostamentoErrato() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "18-13" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18-13"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_presaSempliceCorretta() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "21-18" + System.lineSeparator() + "9-13"
                    + System.lineSeparator() + "18x9" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 18x9"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        } 
    }

    @Test
    void testMenuDiGioco_presaSempliceErrata() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "18x8" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18x8"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_presaMultiplaCorretta() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "22-18" + System.lineSeparator() + "11-15" + System.lineSeparator() + "21-17"
                    + System.lineSeparator() + "12-16"  + System.lineSeparator() + "26-21"  + System.lineSeparator() + "8-12"
                    + System.lineSeparator() + "29-26"  + System.lineSeparator() + "4-8"  + System.lineSeparator() + "24-20"
                    + System.lineSeparator() + "10-14" + System.lineSeparator() + "18x11x4"  + System.lineSeparator() + "abbandona"
                    + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertTrue(Damiera.getDamiera().getListaMosse().contains("B. 18x11x4"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_presaMultiplaErrata() {
        ByteArrayInputStream in = null;
        try {
            String sequenzaDiComandi = "18x13x10" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            Partita.nuovaPartita();
            Partita.getPartita().giocaPartita();
            assertFalse(Damiera.getDamiera().getListaMosse().contains("B. 18x13x10"));
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testMenuDiGioco_comandoErrato() {
        try {
            PrintStream backupOut = System.out;
            
            String sequenzaDiComandi = "comando errato" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";
            
            ByteArrayInputStream in = new ByteArrayInputStream((sequenzaDiComandi).getBytes("utf-8"));
            InterfacciaInput.setInputStream(in);
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Partita.nuovaPartita();
            Partita partita = Partita.getPartita();
            
            menuDiGioco(partita.getGiocatore1(), partita.getGiocatore2());
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("Comando inserito non valido."));
            
            Partita.azzeraPartitaCorrente();
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
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
