/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.time.LocalTime;

import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author mtubi
 */
public class GiocatoreTest {
    
    private static Giocatore giocatore =null;
    
    @BeforeEach
    void setUp(){
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
    void testCostruttore_numeroSbagliato(){
        Giocatore nuovoGiocatore = new Giocatore(3);
        String nomeAspettato = "Giocatore 2";
        assertEquals(nomeAspettato, nuovoGiocatore.getNome());
    }
    
    @Test
    void testAggiornaTempoPassato(){
        LocalTime tempoNullo = LocalTime.of(0, 0, 0);
        giocatore.aggiornaTempoPassato();
        assertNotEquals(tempoNullo, giocatore.getTempoPassato());
    }
    
    @Test
    void testInzioMossa(){
        giocatore.iniziaMossa();
        assertNotEquals(0, giocatore.getMossaCorrente());
    }
}
