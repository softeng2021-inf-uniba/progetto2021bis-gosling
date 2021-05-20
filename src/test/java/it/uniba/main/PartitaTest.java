/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author mtubi
 */
public class PartitaTest {
    static Partita partita = null;
    
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
    void testNuovaPartita(){
        Partita.nuovaPartita();
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
        partita.stampaTempoPassato();
    }
}
