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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mtubi
 */
public class PedinaTest {

    private static Pedina pedina = null;

    @BeforeAll
    static void setUpAll() {
        pedina = new Pedina(Colore.bianco);
    }

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
        Pedina.setInvertiColore(false);

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_sempliceNeraNonInvertita() {
        Pedina.setInvertiColore(false);
        pedina = new Pedina(Colore.nero);

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_sempliceBiancaInvertita() {
        Pedina.setInvertiColore(true);

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_sempliceNeraInvertita() {
        Pedina.setInvertiColore(true);
        pedina = new Pedina(Colore.nero);

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_reBiancaNonInvertita() {
        Pedina.setInvertiColore(false);
        pedina.promuoviADama();

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_reNeroNonInvertita() {
        Pedina.setInvertiColore(false);
        pedina = new Pedina(Colore.nero);
        pedina.promuoviADama();

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_reBiancoInvertita() {
        Pedina.setInvertiColore(true);
        pedina.promuoviADama();

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

    @Test
    void testStampaPedina_reNeroInvertito() {
        Pedina.setInvertiColore(true);
        pedina = new Pedina(Colore.nero);
        pedina.promuoviADama();

        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        pedina.stampaPedina();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }
}
