/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author mtubi
 */
public class GiocatoreTest {
    static Giocatore giocatore =null;
    
    @BeforeAll
    static void setupAll(){
        giocatore = new Giocatore(1);
    }
    
    @Test
    void testGetNome(){
        assertNotNull(giocatore.getNome());
    }
    
    @Test
    void testGetColore(){
        assertNotNull(giocatore.getColore());
    }
    
    @Test
    void testGetColoreAvversario(){
        Giocatore giocatore2 = new Giocatore(2);
        assertNotEquals(giocatore2.getColoreAvversario(), giocatore.getColoreAvversario());
    }
    
    @Test
    void testGetTempoPassato(){
        assertNotNull(giocatore.getTempoPassato());
    }
    
    @Test
    void testGetMossaCorrente(){
        assertNotNull(giocatore.getMossaCorrente());
    }
    
    @Test
    void testCostruttore_numeroSbagliato(){
        Giocatore nuovoGiocatore = new Giocatore(3);
        String nomeAspettato = "Giocatore 2";
        assertEquals(nomeAspettato, nuovoGiocatore.getNome());
    }
}
