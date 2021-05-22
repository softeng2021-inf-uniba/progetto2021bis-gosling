/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.Pedina.Colore;
import it.uniba.main.Pedina.TipoPedina;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author mtubi
 */
public class PedinaTest {

    private static Pedina pedina = null;

    @BeforeEach
    void setUp() {
        pedina = new Pedina(Colore.bianco);
    }

    @Test
    void testGetColore() {
        assertNotNull(pedina.getColore());
    }

    @Test
    void testGetTipo() {
        assertNotNull(pedina.getTipo());
    }

    @Test
    void testPromuoviADama() {
        pedina.promuoviADama();
        assertNotEquals(TipoPedina.pedinaSemplice, pedina.getTipo());
    }

    @Test
    void testStampaPedina_sempliceBiancaNonInvertita() {
        try {
            Pedina.setInvertiColore(false);
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_sempliceNeraNonInvertita() {
        try {
            Pedina.setInvertiColore(false);
            pedina = new Pedina(Colore.nero);
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_sempliceBiancaInvertita() {
        try {
            Pedina.setInvertiColore(true);
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_sempliceNeraInvertita() {
        try {
            Pedina.setInvertiColore(true);
            pedina = new Pedina(Colore.nero);
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_reBiancaNonInvertita() {
        try {
            Pedina.setInvertiColore(false);
            pedina.promuoviADama();
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_reNeroNonInvertita() {
        try {
            Pedina.setInvertiColore(false);
            pedina = new Pedina(Colore.nero);
            pedina.promuoviADama();
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_reBiancoInvertita() {
        try {
            Pedina.setInvertiColore(true);
            pedina.promuoviADama();
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    void testStampaPedina_reNeroInvertito() {
        try {
            Pedina.setInvertiColore(true);
            pedina = new Pedina(Colore.nero);
            pedina.promuoviADama();
            
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            pedina.stampaPedina();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").length() != 0);
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }
}
