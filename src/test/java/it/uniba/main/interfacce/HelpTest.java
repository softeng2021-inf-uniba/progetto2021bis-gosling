/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main.interfacce;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author giuse
 */
public class HelpTest {

    private static Help help = null;
    
    @BeforeAll
    static void setUpAll() {
        help = Help.getHelp();
    }

    @Test
    void testStampaHelpMenu() {
        try {
            PrintStream backupOut = System.out;
            
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent,true,"utf-8"));
            
            Help.stampaHelpMenu();
            
            System.setOut(backupOut);
            
            assertTrue(outContent.toString("utf-8").contains("HELP"));
        } catch (UnsupportedEncodingException ex) {
            fail(ex.getMessage());
        }
    }

}
