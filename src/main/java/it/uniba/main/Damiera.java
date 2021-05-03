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
    private Pedina[][] damieraGioco;
    private int pedineNereMangiate;
    private int pedineBiancheMangiate;

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

    public void setDamieraGioco(Pedina[][] damieraGioco) {
        this.damieraGioco = damieraGioco;
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
        int rigaBaseNemica = (coloreGiocatore == Colore.bianco) ? 0 : 7;

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

            // Aggiungi la mossa all'elenco di mosse
            if (posArrivo.riga == rigaBaseNemica) {
                System.out.println("Hai effettuato la damatura!");
                this.damieraGioco[posArrivo.riga][posArrivo.colonna].promuoviADama();
            }

        } else {
            if (coloreSbagliato) {
                System.out.println("Non puoi spostare una pedina del tuo avversario");
            } else {
                System.out.println("Mossa non valida.");
            }
        }

        return spostamentoLecito;
    }

    public boolean effettuaPresaSemplice(String mossa, Colore coloreGiocatore) {
        boolean presaLecita = false;
        boolean posParValida = false;
        boolean posArrValida = false; // Spazio di arrivo occupato
        boolean coloreGiusto = false;
        boolean rigaCorretta = false;
        boolean colonnaCorretta = false;
        boolean presaPossibile = false;
        boolean presaPossibileDamatura = false;

        String[] numeri = mossa.split("x");

        Posizione posPartenza = Damiera.convertiNumeroInPosizione(Integer.valueOf(numeri[0]));
        Posizione posArrivo = Damiera.convertiNumeroInPosizione(Integer.valueOf(numeri[1]));

        Pedina contenutoPosPar = this.damieraGioco[posPartenza.riga][posPartenza.colonna];

        Pedina contenutoPosArr = this.damieraGioco[posArrivo.riga][posArrivo.colonna];

        // ci serve che sia fuori dagli if perché nello spostamento è importante
        Pedina daMangiare;
        Posizione posDaMangiare = new Posizione();
        int versoAvanzamento = (coloreGiocatore == Colore.bianco) ? -1 : 1;
        int rigaBaseNemica = (coloreGiocatore == Colore.bianco) ? 0 : 7;
        if (contenutoPosPar != null) {
            posParValida = true;
            if (contenutoPosPar.getColore() == coloreGiocatore) {  // se il colore è il giusto
                coloreGiusto = true;
                if (contenutoPosArr == null) { // se lo spostamento non va in una casella già piena
                    posArrValida = true;

                    if (contenutoPosPar.getTipo() == TipoPedina.pedinaSemplice) {
                        rigaCorretta = (posArrivo.riga == (posPartenza.riga + versoAvanzamento * 2));
                    } else {
                        rigaCorretta = (posArrivo.riga == (posPartenza.riga + versoAvanzamento * 2) || posArrivo.riga == (posPartenza.riga - versoAvanzamento * 2));
                    }

                    colonnaCorretta = (posArrivo.colonna == (posPartenza.colonna - 2) || posArrivo.colonna == (posPartenza.colonna + 2));
                    if (rigaCorretta && colonnaCorretta) // se la mossa è valida
                    {

                        posDaMangiare.riga = (posPartenza.riga + 1 * versoAvanzamento);
                        /*
                        Quando implementeremo gli spostamenti della dama, il controllo sulla riga andrà svolto.
                         */

                        if (posArrivo.colonna > posPartenza.colonna) {
                            posDaMangiare.colonna = posPartenza.colonna + 1;
                        } else {
                            posDaMangiare.colonna = posPartenza.colonna - 1;
                        }

                        daMangiare = this.damieraGioco[posDaMangiare.riga][posDaMangiare.colonna];

                        if (daMangiare != null && daMangiare.getColore() != coloreGiocatore) // Se c'è qualcosa di effettivo da mangiare
                        {
                            presaPossibile = true;
                            if (contenutoPosPar.getTipo() == TipoPedina.pedinaRe) // se è una dama può mangiare tutto
                            {
                                presaPossibileDamatura = true;
                                presaLecita = true;
                            } else {
                                if (daMangiare.getTipo() != TipoPedina.pedinaRe) // altrimenti non può mangiare la dama
                                {
                                    presaPossibileDamatura = true;
                                    presaLecita = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Perfetto per il terzo sprint, perché è orribile
        if (posParValida == false) {
            System.out.println("Presa non valida. La casella di partenza è vuota");
        } else if (posArrValida == false) {
            System.out.println("Presa non valida. La casella di arrivo non è vuota");
        } else if (coloreGiusto == false) {
            System.out.println("Non puoi spostare una pedina del tuo avversario");
        } else if (!(rigaCorretta && colonnaCorretta)) {
            System.out.println("Movimento non lecito.");
        } else if (presaPossibile == false) {
            System.out.println("Presa non possibile");
        } else if (presaPossibileDamatura == false) {
            System.out.println("Non puoi mangiare una dama con una pedina semplice");
        }

        if (presaLecita == true) {
            this.damieraGioco[posDaMangiare.riga][posDaMangiare.colonna] = null;
            this.damieraGioco[posArrivo.riga][posArrivo.colonna] = this.damieraGioco[posPartenza.riga][posPartenza.colonna];
            this.damieraGioco[posPartenza.riga][posPartenza.colonna] = null;
            if (posArrivo.riga == rigaBaseNemica) {
                System.out.println("Hai effettuato la damatura!");
                this.damieraGioco[posArrivo.riga][posArrivo.colonna].promuoviADama();
            }
            if (coloreGiocatore == Colore.bianco) {
                incrementaPreseNere();
            } else {
                incrementaPreseBianche();
            }
            // Aggiungi la pedina mangiata alla lista delle pedine mangiate
            // aggiungi la mossa alle liste di mosse effettuate nella partita
        }

        return presaLecita;
    }

    public boolean effettuaPresaMultipla(String mossa, Colore coloreGiocatore) {
        boolean presaMultiplaLecita = false;

        int contatoreMosse = 0;
        String[] numeri = mossa.split("x");

        String[] prese = new String[numeri.length - 1];

        for (int i = 0; i < numeri.length - 1; i++) // Tokenizzazine mosse
        {
            prese[contatoreMosse] = String.join("x", numeri[i], numeri[i + 1]);
            contatoreMosse++;

        }

        // Backup damiera nel caso le mosse non siano legali
        Pedina[][] damieraBackup = new Pedina[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                damieraBackup[i][j] = damieraGioco[i][j];
            }
        }

        int contaTestPrese = 0;

        while (contaTestPrese < prese.length) { // Per ogni mossa, verifica se è lecita
            boolean correct = effettuaPresaSemplice(prese[contaTestPrese], coloreGiocatore);

            if (!correct) {
                presaMultiplaLecita = false; // se anche solo 1 mossa non è lecita, esce
                break;
            } else {
                presaMultiplaLecita = true;
            }
            contaTestPrese++;
        }

        if (!presaMultiplaLecita) {

            this.setDamieraGioco(damieraBackup); //Se una delle mosse non era lecita, resetta la damiera com'era prima
        } else {
            // Aggiungi pedine tolte alla lista delle pedine
            // Aggiungi mossa alla lista delle mosse
            if (coloreGiocatore == Colore.bianco) {
                incrementaPreseNere();
            } else {
                incrementaPreseBianche();
            }
        }

        return presaMultiplaLecita;
    }

    public void incrementaPreseBianche() {
        this.pedineBiancheMangiate++;
    }

    public void incrementaPreseNere() {
        this.pedineNereMangiate++;
    }

    public void stampaPedineMangiate() {
        System.out.print("Nero: ");
        for (int i = 0; i < pedineBiancheMangiate; i++) {
            System.out.print('\u26C0' + " ");
        }
        System.out.print("\nBianco: ");
        for (int i = 0; i < pedineNereMangiate; i++) {
            System.out.print('\u26C2' + " ");

        }

        System.out.println("");
    }
}
