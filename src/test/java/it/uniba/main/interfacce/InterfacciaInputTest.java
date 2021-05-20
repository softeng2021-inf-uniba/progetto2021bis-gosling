/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;


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
    void setUp(){
        
    } 
    
    @Test
    void testChiediConferma_affermativo(){
        InputStream backupIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("si".getBytes());
        
        System.setIn(in);
        assertTrue(chiediConferma("Domanda","Caso affermativo","Caso negativo"));
        System.setIn(backupIn);
    }
    
    @Test
    void testChiediConferma_negativo(){
        InputStream backupIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("no".getBytes());
        System.setIn(in);
        assertFalse(chiediConferma("Domanda","Caso affermativo","Caso negativo"));
        System.setIn(backupIn);
    }
    
    @Test
    void testChiediConferma_inputErrato(){
        InputStream backupIn = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(("errato" + System.lineSeparator() + "si").getBytes());
        System.setIn(in);
        assertTrue(chiediConferma("Domanda","Caso affermativo","Caso negativo"));
        System.setIn(backupIn);
    }
    
    @Test
    void testMenuDiInizio_help() {
        InputStream backupIn = System.in;
        PrintStream backupOut = System.out;
        System.out.println("ooooooooooooooo");
        String commandSequence = "help" + System.lineSeparator() + "numeri" + System.lineSeparator() + "esci";
        
        ByteArrayInputStream in = new ByteArrayInputStream((commandSequence).getBytes());
        System.setIn(in);
        
        //ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(outContent));

        menuDiInizio();
        
        System.setIn(backupIn);
        System.setOut(backupOut);
        
        //System.out.println("oooooooooooooo" + outContent.toString());
        //assertTrue(outContent.toString().length() != 0);
    }
    
}
