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
    
}
