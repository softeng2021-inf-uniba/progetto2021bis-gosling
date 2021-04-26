package it.uniba.main;

import it.uniba.main.types.Colore;
import it.uniba.main.types.Posizione;
import it.uniba.main.types.TipoPedina;

/**
 *
 * @author Pasquale & Massimo
 */
public class Damiera {

    /* ------------ Stato ------------ */
    private static Damiera singleIstance; // Per rendere la classe singleton
    private static final Posizione[] vettorePosizioni = new Posizione[32];
    private final int[][] damieraNumeri;
    private final Pedina[][] damieraGioco;

    /* ------------  Costruttori ------------ */
    private Damiera() {
        damieraGioco = new Pedina[8][8];
        damieraNumeri = new int[8][8];
        int counter = 1;
        preparaDamiera();
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 0) {
                        damieraNumeri[i][j] = counter;
                        counter++;
                    } else {
                        damieraNumeri[i][j] = 0;
                    }
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    if (j % 2 == 1) {
                        damieraNumeri[i][j] = counter;
                        counter++;
                    } else {
                        damieraNumeri[i][j] = 0;
                    }
                }
            }
        }
        
        Damiera.inizializzaVettorePosizioni();
    }

    /* ------------ Get & Set ------------*/
    public static Damiera getDamiera() // Serve ad ottenere damiera
    {
        if (singleIstance == null) {
            singleIstance = new Damiera();
        }

        return singleIstance;
    }

    /* ------------ Metodi ------------*/
    private static void inizializzaVettorePosizioni() {

        int rigaCorrente = 0;
        int colonnaCorrente = 0;
        int posizioniRigaCorrente = 0;

        for (int i = 0; i < 32; i++) {
            vettorePosizioni[i] = new Posizione(rigaCorrente, colonnaCorrente);
            posizioniRigaCorrente++;

            if (posizioniRigaCorrente == 4) {
                rigaCorrente++;

                if (rigaCorrente % 2 == 0) {
                    colonnaCorrente = 0;
                } else {
                    colonnaCorrente = 1;
                }

                posizioniRigaCorrente = 0;
            } else {
                colonnaCorrente += 2;
            }

        }
    }

    private static Posizione convertiNumeroInPosizione(int num) {
        return vettorePosizioni[num - 1];
    }

    public final void preparaDamiera() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        damieraGioco[i][j] = new Pedina(Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 == 1) {
                        damieraGioco[i][j] = new Pedina(Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                }
            }
        }
        for (int i = 3; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                damieraGioco[i][j] = null;
            }
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        damieraGioco[i][j] = new Pedina(Colore.bianco);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 == 1) {
                        damieraGioco[i][j] = new Pedina(Colore.bianco);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                }
            }
        }
    }
    
    public void stampaNumeri() {
        char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                if (damieraNumeri[i][j] != 0) {
                    if (damieraNumeri[i][j] > 9) {
                        System.out.print(damieraNumeri[i][j]);
                        System.out.print(space);
                    } else {
                        System.out.print(space);
                        System.out.print(damieraNumeri[i][j]);
                        System.out.print(space);
                    }
                } else {
                    System.out.print(space);
                    System.out.print(space);
                    System.out.print(space);
                }
                System.out.print("|");
            }
            System.out.println(""); // serve per mandare a capo e non usare \n che non funziona su macchine non Windows
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
    }

    public void stampaPedine() {
        // System.out.println("+-──-+-──-+-──-+-──-+-──-+-──-+-──-+-──-+");

        char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (damieraGioco[i][j] != null) {
                    System.out.print("|" + space);
                    damieraGioco[i][j].stampaPedina();
                    System.out.print("" + space);
                } else {
                    System.out.print("|" + space + '\u2003' + space);
                }
            }
            System.out.println("|");
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
    }

    public boolean spostamentoPedina(String mossa, Colore coloreGiocatore) {

        boolean spostamentoLecito = false;

        String[] numeri = mossa.split("-");
        
        Posizione posPartenza = Damiera.convertiNumeroInPosizione(Integer.valueOf(numeri[0]));
        Posizione posArrivo = Damiera.convertiNumeroInPosizione(Integer.valueOf(numeri[1]));

        Pedina contenutoPosPar = this.damieraGioco[posPartenza.riga][posPartenza.colonna];
        Pedina contenutoPosArr = this.damieraGioco[posArrivo.riga][posArrivo.colonna];

        boolean coloreSbagliato = false;

        if (contenutoPosPar != null) {
            coloreSbagliato = (contenutoPosPar.getColore() != coloreGiocatore);
        }

        int versoAvanzamento = (coloreGiocatore == Colore.bianco) ? -1 : 1;

        if (contenutoPosPar != null && contenutoPosArr == null) {

            if (!coloreSbagliato) {

                boolean rigaCorretta;
                boolean colonnaCorretta;

                if (contenutoPosPar.getTipo() == TipoPedina.pedinaSemplice) {
                    rigaCorretta = (posArrivo.riga == (posPartenza.riga + versoAvanzamento));
                } else {
                    rigaCorretta = (posArrivo.riga == (posPartenza.riga + versoAvanzamento) || posArrivo.riga == (posPartenza.riga - versoAvanzamento));
                }

                colonnaCorretta = (posArrivo.colonna == (posPartenza.colonna - 1) || posArrivo.colonna == (posPartenza.colonna + 1));

                spostamentoLecito = rigaCorretta && colonnaCorretta;
            }
        }

        if (spostamentoLecito) {
            this.damieraGioco[posArrivo.riga][posArrivo.colonna] = this.damieraGioco[posPartenza.riga][posPartenza.colonna];
            this.damieraGioco[posPartenza.riga][posPartenza.colonna] = null;
            this.stampaPedine();
        } else {
            if (coloreSbagliato) {
                System.out.println("Non puoi spostare una pedina del tuo avversario");
            } else {
                System.out.println("Mossa non valida.");
            }
        }

        return spostamentoLecito;
    }
}
