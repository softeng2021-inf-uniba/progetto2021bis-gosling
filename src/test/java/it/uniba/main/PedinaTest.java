/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;
import it.uniba.main.Pedina.Colore;
import it.uniba.main.Pedina.TipoPedina;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author mtubi
 */
public class PedinaTest {
    static Pedina pedina = null;
    
    @BeforeAll
    static void setUpAll(){
        pedina = new Pedina(Colore.bianco);
    }
    
    @BeforeEach
    void setUp(){
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
    
    @Test
    void testPromuoviADama(){
        pedina.promuoviADama();
        assertNotEquals(TipoPedina.pedinaSemplice, pedina.getTipo());
    }
    
    @Test
    void testStampaPedina_sempliceBiancaNonInvertita(){
        Pedina.setInvertiColore(true);
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_sempliceNeraNonInvertita(){
        Pedina.setInvertiColore(true);
        pedina = new Pedina(Colore.nero);
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_sempliceBiancaInvertita(){
        Pedina.setInvertiColore(false);
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_sempliceNeraInvertita(){
        Pedina.setInvertiColore(false);
        pedina = new Pedina(Colore.nero);
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_reBiancaNonInvertita(){
        Pedina.setInvertiColore(true);
        pedina.promuoviADama();
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_reNeroNonInvertita(){
        Pedina.setInvertiColore(true);
        pedina = new Pedina(Colore.nero);
        pedina.promuoviADama();
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_reBiancoInvertita(){
        Pedina.setInvertiColore(false);
        pedina.promuoviADama();
        pedina.stampaPedina();
    }
    
    @Test
    void testStampaPedina_reNeroInvertito(){
        Pedina.setInvertiColore(false);
        pedina = new Pedina(Colore.nero);
        pedina.promuoviADama();
        pedina.stampaPedina();
    }
}
