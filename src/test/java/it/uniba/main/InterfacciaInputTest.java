/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;


import static it.uniba.main.interfacce.InterfacciaInput.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Disabled;
/**
 *
 * @author mtubi
 */
public class InterfacciaInputTest {
    @Disabled
    @Test
    void testChiediConferma_affermativo(){
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("si".getBytes());
        System.setIn(in);
        System.setIn(sysInBackup);
        assertTrue(chiediConferma("Domanda","Caso affermativo","Caso negativo"));
    }
    
    @Disabled
    @Test
    void testChiediConferma_negativo(){
        
    }
    
    @Disabled
    @Test
    void testChiediConferma_inputErrato(){
        
    }
    
}
