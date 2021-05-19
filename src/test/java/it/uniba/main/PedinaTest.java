/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;
import it.uniba.main.Pedina.Colore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author mtubi
 */
public class PedinaTest {
    static Pedina pedina = null;
    
    @BeforeAll
    static void setupAll(){
        pedina = new Pedina(Colore.bianco);
    }
    
    @Test
    void testGetColore(){
        assertNotNull(pedina.getColore());
    }
    
    @Test
    void testGetTipo(){
        assertNotNull(pedina.getTipo());
    }
}
