/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import it.uniba.main.eccezioni.eccezionePresa;
import it.uniba.main.eccezioni.eccezioneSpostamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author giuse
 */
public class DamieraTest {

    private static Damiera damiera = null;

    @BeforeAll
    static void setUpAll() {
        damiera = Damiera.getDamiera();
    }

    @BeforeEach
    void setUp() {
        damiera.preparaDamiera();
    }

    @Test
    void testGetDamiera() {
        assertNotNull(Damiera.getDamiera());
    }

    @Test
    void testGetListaMosse() {
        assertNotNull(damiera.getListaMosse());
    }

    @Test
    void testGetGrandezzaPosizioni() {
        assertEquals(32, Damiera.getGrandezzaPosizioni());
    }

    @Test
    void testGetDamieraSize() {
        assertEquals(8, Damiera.getDamieraSize());
    }

    @Test
    void testConvertiNumeroInPosizione_numeroValidoMin() {
        int valoreMin = 1;
        assertEquals(0, Damiera.convertiNumeroInPosizione(valoreMin).getRiga());
        assertEquals(0, Damiera.convertiNumeroInPosizione(valoreMin).getColonna());
    }

    @Test
    void testConvertiNumeroInPosizione_numeroValidoMax() {
        int valoreMax = 32;
        assertEquals(7, Damiera.convertiNumeroInPosizione(valoreMax).getRiga());
        assertEquals(7, Damiera.convertiNumeroInPosizione(valoreMax).getColonna());
    }

    @Test
    void testConvertiNumeroInPosizione_numeroNonValidoNegativo() {
        int valoreErrNeg = Integer.MIN_VALUE;
        assertEquals(-1, Damiera.convertiNumeroInPosizione(valoreErrNeg).getRiga());
        assertEquals(-1, Damiera.convertiNumeroInPosizione(valoreErrNeg).getColonna());
    }

    @Test
    void testConvertiNumeroInPosizione_numeroNonValidoPositivo() {
        int valoreErrPos = Integer.MAX_VALUE;
        assertEquals(-1, Damiera.convertiNumeroInPosizione(valoreErrPos).getRiga());
        assertEquals(-1, Damiera.convertiNumeroInPosizione(valoreErrPos).getColonna());
    }

    @Test
    void testSpostamentoPedina_biancoLecito() {
        String mossa = "21-17";
        try {
            assertTrue(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (eccezioneSpostamento exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_neroLecito() {
        String mossa = "9-13";
        try {
            assertTrue(damiera.spostamentoPedina(mossa, Pedina.Colore.nero));
        } catch (eccezioneSpostamento exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_lecitoConDamatura() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("20x11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("15-19", Pedina.Colore.nero);
            assertTrue(damiera.spostamentoPedina("7-4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoIndietroDama() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("20x11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("15-19", Pedina.Colore.nero);
            damiera.spostamentoPedina("7-4", Pedina.Colore.bianco);
            assertTrue(damiera.spostamentoPedina("4-7", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoAvantiDama() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("20x11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("15-19", Pedina.Colore.nero);
            damiera.spostamentoPedina("7-4", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-7", Pedina.Colore.bianco);
            assertTrue(damiera.spostamentoPedina("7-4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_rigaCorrettaColonnaSbagliata() {
        String mossa = "22-17";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_rigaSbagliataColonnaCorretta() {
        String mossa = "22-11";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoErratoDama() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("20x11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("15-19", Pedina.Colore.nero);
            damiera.spostamentoPedina("7-4", Pedina.Colore.bianco);
            assertFalse(damiera.spostamentoPedina("4-11", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoAvversario() {
        String mossa = "9-13";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoPedinaInesistente() {
        String mossa = "17-13";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoInCellaOccupata() {
        String mossa = "29-25";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_spostamentoInCellaSbagliata() {
        String mossa = "21-13";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_daCellaVuotaACellaPiena() {
        String mossa = "18-21";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.nero));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testSpostamentoPedina_daCellaPienaACellaPiena() {
        String mossa = "29-25";
        try {
            assertFalse(damiera.spostamentoPedina(mossa, Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaBiancoCorretta() {
        try {
            damiera.spostamentoPedina("21-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertTrue(damiera.effettuaPresaSemplice("18x9", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaNeroCorretta() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertTrue(damiera.effettuaPresaSemplice("13x22", Pedina.Colore.nero));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Disabled
    @Test
    void testEffettuaPresaSemplice_presaCorrettaSinistra() {
        try {
            damiera.spostamentoPedina("21-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertTrue(damiera.effettuaPresaSemplice("18x9", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Disabled
    @Test
    void testEffettuaPresaSemplice_presaCorrettaDestra() {
        try {
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("10-14", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-18", Pedina.Colore.bianco);
            assertTrue(damiera.effettuaPresaSemplice("18x11", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaConDamatura() {
        try {
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("14-11", Pedina.Colore.bianco);
            assertTrue(damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_rigaSbagliataColonnaCorretta() {
        try {
            damiera.spostamentoPedina("22-19", Pedina.Colore.bianco);
            damiera.spostamentoPedina("10-14", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("19x18", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_rigaCorrettaColonnaSbagliata() {
        try {
            damiera.spostamentoPedina("22-19", Pedina.Colore.bianco);
            damiera.spostamentoPedina("10-14", Pedina.Colore.nero);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("19x9", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Disabled
    @Test
    void testEffettuaPresaSemplice_presaConFalsaDamatura() {
        try {
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("14-11", Pedina.Colore.bianco);
            damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("3-7", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaConDamaInAvanti() {
        try {
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("14-11", Pedina.Colore.bianco);
            damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-7", Pedina.Colore.bianco);
            damiera.spostamentoPedina("7-11", Pedina.Colore.bianco);
            damiera.spostamentoPedina("3-7", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaConDamaIndietro() {
        try {
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("14-11", Pedina.Colore.bianco);
            damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco);
            damiera.spostamentoPedina("3-7", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("4x11", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaVuota() {
        try {
            assertFalse(damiera.effettuaPresaSemplice("21x14", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_biancoPrendeConNero() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("13x22", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_biancoPrendeBianco() {
        try {
            damiera.spostamentoPedina("21-18", Pedina.Colore.bianco);
            assertFalse(damiera.effettuaPresaSemplice("22x13", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_presaDaCellaVuota() {
        try {
            assertFalse(damiera.effettuaPresaSemplice("18x11", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_cellaArrivoOccupata() {
        try {
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaSemplice("17x10", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaSemplice_provaAMangiareDama() {
        try {
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("18-14", Pedina.Colore.bianco);
            damiera.spostamentoPedina("14-11", Pedina.Colore.bianco);
            damiera.effettuaPresaSemplice("11x4", Pedina.Colore.bianco);
            damiera.spostamentoPedina("15-19", Pedina.Colore.nero);
            damiera.spostamentoPedina("12-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("4-7", Pedina.Colore.bianco);
            assertFalse(damiera.effettuaPresaSemplice("3x12", Pedina.Colore.nero));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaMultipla_presaLecita() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("10-14", Pedina.Colore.nero);
            assertTrue(damiera.effettuaPresaMultipla("18x11x4", Pedina.Colore.bianco));
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testEffettuaPresaMultipla_presaNonLecita() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("11-15", Pedina.Colore.nero);
            damiera.spostamentoPedina("21-17", Pedina.Colore.bianco);
            damiera.spostamentoPedina("12-16", Pedina.Colore.nero);
            damiera.spostamentoPedina("26-21", Pedina.Colore.bianco);
            damiera.spostamentoPedina("8-12", Pedina.Colore.nero);
            damiera.spostamentoPedina("29-26", Pedina.Colore.bianco);
            damiera.spostamentoPedina("4-8", Pedina.Colore.nero);
            damiera.spostamentoPedina("24-20", Pedina.Colore.bianco);
            damiera.spostamentoPedina("10-14", Pedina.Colore.nero);
            assertFalse(damiera.effettuaPresaMultipla("18x11x3", Pedina.Colore.bianco));
        } catch (Exception exc) {
            System.out.println("Test passato: " + exc.getMessage());
        }
    }

    @Test
    void testStampaNumeri() {
        damiera.stampaNumeri();
    }

    @Test
    void testStampaPedine() {
        damiera.stampaPedine();
    }

    @Test
    void testStampaPeidneMangiate_bianche() {
        try {
            damiera.spostamentoPedina("21-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("18x9", Pedina.Colore.bianco);
            damiera.stampaPedineMangiate();
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testStampaPedineMangiate_nere() {
        try {
            damiera.spostamentoPedina("22-18", Pedina.Colore.bianco);
            damiera.spostamentoPedina("9-13", Pedina.Colore.nero);
            damiera.effettuaPresaSemplice("13x22", Pedina.Colore.nero);
            damiera.stampaPedineMangiate();
        } catch (Exception exc) {
            fail(exc.getMessage());
        }
    }

    @Test
    void testStampaMosse() {
        damiera.registraMossa("8-9", Pedina.Colore.bianco);
        damiera.stampaMosse();
    }

    @Test
    void testRegistraMossa_bianco() {
        damiera.registraMossa("8-9", Pedina.Colore.bianco);
    }

    @Test
    void testRegistraMossa_nero() {
        damiera.registraMossa("8-9", Pedina.Colore.nero);
    }
    
    @Test
    void testSetListaMosse(){
        damiera.setListaMosse(null);
    }
    
}
