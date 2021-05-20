/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author mtubi
 */
public class PartitaTest {
    
    private static Partita partita = null;
    
    @BeforeAll
    static void setUpAll() {
        Partita.nuovaPartita();
        partita = Partita.getPartita();
    }
    
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
    
    @Test//Da finire
    void testStampaTempoPassato(){
        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        partita.stampaTempoPassato();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }
}
