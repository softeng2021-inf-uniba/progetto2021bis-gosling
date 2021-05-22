/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.interfacce.InterfacciaInput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author mtubi
 */
public class PartitaTest {
    
    private Partita partita = null;
    
    @BeforeEach
    void setUp() {
        Partita.nuovaPartita();
        partita = Partita.getPartita();
    }
    
    @Test
    void testGetPartita(){
        assertNotNull(Partita.getPartita());
    }
    
    @Test
    void testIsFinita(){
        assertFalse(partita.isFinita());
    }
    
    @Test
    void testFinisciPerrtita(){
        partita.finisciPartita();
        assertTrue(partita.isFinita());
    }
    
    @Test
    void testAzzeraPartitaCorrente(){
        Partita.azzeraPartitaCorrente();
        assertNull(Partita.getPartita());
    }
    
    @Test
    void testStampaTempoPassato_giocatore1(){
        PrintStream backupOut = System.out;

        String commandSequence = "tempo" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        partita.giocaPartita();

        System.setOut(backupOut);
        
        assertTrue(outContent.toString().contains("tempo"));

        Partita.azzeraPartitaCorrente();
    }    
    
    @Test
    void testStampaTempoPassato_giocatore2(){
        PrintStream backupOut = System.out;

        String commandSequence = "22-18" + System.lineSeparator() + "tempo" + System.lineSeparator() + "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        partita.giocaPartita();

        System.setOut(backupOut);
        
        assertTrue(outContent.toString().contains("tempo"));

        Partita.azzeraPartitaCorrente();
    }
    
    @Test
    void testGetGiocatore1(){
        assertEquals(Pedina.Colore.bianco, partita.getGiocatore1().getColore());
    }
        
    @Test
    void testGetGiocatore2(){
        assertEquals(Pedina.Colore.nero, partita.getGiocatore2().getColore());
    }
    
    @Test
    void testNuovoTurno(){
        PrintStream backupOut = System.out;

        String commandSequence = "abbandona" + System.lineSeparator() + "si";

        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        InterfacciaInput.setInputStream(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        partita.giocaPartita();

        System.setOut(backupOut);
        
        assertTrue(outContent.toString().contains("turno di"));

        Partita.azzeraPartitaCorrente();
    }
}
