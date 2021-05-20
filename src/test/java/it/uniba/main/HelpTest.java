/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.Help;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author giuse
 */
public class HelpTest {

    private static Help help = null;
    
    @BeforeAll
    static void setUpAll() {
        help = new Help();
    }

    @Test
    void testStampaHelpMenu() {
        PrintStream backupOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Help.stampaHelpMenu();

        System.setOut(backupOut);

        assertTrue(outContent.toString().length() != 0);
    }

}