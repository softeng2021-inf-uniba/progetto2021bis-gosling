package it.uniba.main;

import it.uniba.main.types.Colore;
import it.uniba.main.types.Posizione;
import it.uniba.main.types.TipoPedina;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tipo classe: <<Entity>>
 *
 * Gestisce la Damiera di una partita e effettua le operazioni sulla damiera
 * stessa. Tiene ulteriormente conto dello stato della partita registrando le
 * pedine e le loro posizioni, pedine mangiate e la lista delle mosse
 *
 */
public final class Damiera {

    /* ------------ Stato ------------ */
    private static final int GRANDEZZA_POSIZIONI = 32;
    private static final int DAMIERA_SIZE = 8;
    private static Damiera singleIstance = null;  // Per rendere la classe singleton
    private static final Posizione[] VETTORE_POSIZIONI = new Posizione[GRANDEZZA_POSIZIONI];
    private final int[][] damieraNumeri;
    private Pedina[][] damieraGioco;
    private int pedineNereMangiate;
    private int pedineBiancheMangiate;
    private List<String> listaMosse;

    /* ------------  Costruttori ------------ */
    private Damiera() {
        this.damieraGioco = new Pedina[DAMIERA_SIZE][DAMIERA_SIZE];
        this.damieraNumeri = new int[DAMIERA_SIZE][DAMIERA_SIZE];
        int counter = 1;
        preparaDamiera();
        for (int i = 0; i < DAMIERA_SIZE; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < DAMIERA_SIZE; j++) {
                    if (j % 2 == 0) {
                        this.damieraNumeri[i][j] = counter;
                        counter++;
                    } else {
                        this.damieraNumeri[i][j] = 0;
                    }
                }
            } else {
                for (int j = 0; j < DAMIERA_SIZE; j++) {
                    if (j % 2 != 0) {
                        this.damieraNumeri[i][j] = counter;
                        counter++;
                    } else {
                        this.damieraNumeri[i][j] = 0;
                    }
                }
            }
        }
        this.pedineNereMangiate = 0;
        this.pedineBiancheMangiate = 0;
        Damiera.inizializzaVettorePosizioni();
        this.listaMosse = new ArrayList<>();
    }

    /* ------------ Get & Set ------------*/
    public static Damiera getDamiera() { // Serve ad ottenere damiera
        if (singleIstance == null) {
            singleIstance = new Damiera();
        }
        return singleIstance;
    }

    public List<String> getListaMosse() {
        return listaMosse;
    }

    public void setListaMosse(final List<String> listaMosseIn) {
        this.listaMosse = listaMosseIn;
    }

    public void addListaMose(final String... mosse) {
        listaMosse.addAll(Arrays.asList(mosse));
    }

    public static int getGrandezzaPosizioni() {
        return GRANDEZZA_POSIZIONI;
    }

    public static int getDamieraSize() {
        return DAMIERA_SIZE;
    }

    /* ------------ Metodi ------------*/
    private static void inizializzaVettorePosizioni() {
        int rigaCorrente = 0;
        int colonnaCorrente = 0;
        int posizioniRigaCorrente = 0;
        final int cambioPosizione = 4;
        for (int i = 0; i < GRANDEZZA_POSIZIONI; i++) {
            VETTORE_POSIZIONI[i] = new Posizione(rigaCorrente, colonnaCorrente);
            posizioniRigaCorrente++;

            if (posizioniRigaCorrente == cambioPosizione) {
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

    private static Posizione convertiNumeroInPosizione(final int num) {
        return VETTORE_POSIZIONI[num - 1];
    }

    public void preparaDamiera() {
        final int primaParte = 3;
        final int secondaParte = 5;
        this.listaMosse = new ArrayList<>();
        this.pedineBiancheMangiate = 0;
        this.pedineNereMangiate = 0;
        for (int i = 0; i < primaParte; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        damieraGioco[i][j] = new Pedina(Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 != 0) {
                        damieraGioco[i][j] = new Pedina(Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                }
            }
        }
        for (int i = primaParte; i < secondaParte; i++) {
            for (int j = 0; j < secondaParte; j++) {
                damieraGioco[i][j] = null;
            }
        }
        for (int i = secondaParte; i < DAMIERA_SIZE; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        damieraGioco[i][j] = new Pedina(Colore.bianco);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 != 0) {
                        damieraGioco[i][j] = new Pedina(Colore.bianco);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                }
            }
        }
    }

    public void stampaNumeri() {
        final int sogliaDoppia = 9;
        final char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < DAMIERA_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < DAMIERA_SIZE; j++) {
                if (damieraNumeri[i][j] != 0) {
                    if (damieraNumeri[i][j] > sogliaDoppia) {
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

        final char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for (int i = 0; i < DAMIERA_SIZE; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
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

    public boolean spostamentoPedina(final String mossa, final Colore coloreGiocatore) {

        boolean spostamentoLecito = false;

        String[] numeri = mossa.split("-");

        Posizione posPartenza = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[0]));
        Posizione posArrivo = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[1]));

        Pedina contenutoPosPar = this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()];
        Pedina contenutoPosArr = this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()];

        boolean coloreSbagliato = false;

        if (contenutoPosPar != null) {
            coloreSbagliato = (contenutoPosPar.getColore() != coloreGiocatore);
        }
        int versoAvanzamento;
        int rigaBaseNemica;
        if (coloreGiocatore == Colore.bianco) {
            versoAvanzamento = -1;
            rigaBaseNemica = 0;
        } else {
            versoAvanzamento = 1;
            rigaBaseNemica = DAMIERA_SIZE - 1;
        }

        if (contenutoPosPar != null && contenutoPosArr == null) {

            if (!coloreSbagliato) {

                boolean rigaCorretta;
                boolean colonnaCorretta;

                if (contenutoPosPar.getTipo() == TipoPedina.pedinaSemplice) {
                    rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento));
                } else {
                    rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento)
                            || posArrivo.getRiga() == (posPartenza.getRiga() - versoAvanzamento));
                }

                colonnaCorretta = (posArrivo.getColonna() == (posPartenza.getColonna() - 1)
                        || posArrivo.getColonna() == (posPartenza.getColonna() + 1));

                spostamentoLecito = rigaCorretta && colonnaCorretta;
            }
        }

        if (spostamentoLecito) {
            this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()]
                    = this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()];
            this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()] = null;

            // Aggiungi la mossa all'elenco di mosse
            if (posArrivo.getRiga() == rigaBaseNemica) {
                System.out.println("Hai effettuato la damatura!");
                this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()].promuoviADama();
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

    public boolean effettuaPresaSemplice(final String mossa, final Colore coloreGiocatore) {
        boolean presaLecita = false;
        boolean posParValida = false;
        boolean posArrValida = false; // Spazio di arrivo occupato
        boolean coloreGiusto = false;
        boolean rigaCorretta = false;
        boolean colonnaCorretta = false;
        boolean presaPossibile = false;
        boolean presaPossibileDamatura = false;

        String[] numeri = mossa.split("x");

        Posizione posPartenza = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[0]));
        Posizione posArrivo = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[1]));

        Pedina contenutoPosPar = this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()];

        Pedina contenutoPosArr = this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()];

        // ci serve che sia fuori dagli if perché nello spostamento è importante
        Pedina daMangiare;
        Posizione posDaMangiare = new Posizione();

        int versoAvanzamento;
        int rigaBaseNemica;
        if (coloreGiocatore == Colore.bianco) {
            versoAvanzamento = -1;
            rigaBaseNemica = 0;
        } else {
            versoAvanzamento = 1;
            rigaBaseNemica = DAMIERA_SIZE - 1;
        }

        if (contenutoPosPar != null) {
            posParValida = true;
            if (contenutoPosPar.getColore() == coloreGiocatore) {  // se il colore è il giusto
                coloreGiusto = true;
                if (contenutoPosArr == null) { // se lo spostamento non va in una casella già piena
                    posArrValida = true;

                    if (contenutoPosPar.getTipo() == TipoPedina.pedinaSemplice) {
                        rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento * 2));
                    } else {
                        rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento * 2)
                                || posArrivo.getRiga() == (posPartenza.getRiga() - versoAvanzamento * 2));
                    }

                    colonnaCorretta = (posArrivo.getColonna() == (posPartenza.getColonna() - 2)
                            || posArrivo.getColonna() == (posPartenza.getColonna() + 2));
                    if (rigaCorretta && colonnaCorretta) { // se la mossa è valida
                        posDaMangiare.setRiga((posPartenza.getRiga() + 1 * versoAvanzamento));
                        /*
                        Quando implementeremo gli spostamenti della dama, il controllo sulla riga andrà svolto.
                         */
                        if (posArrivo.getColonna() > posPartenza.getColonna()) {
                            posDaMangiare.setColonna((posPartenza.getColonna() + 1));
                        } else {
                            posDaMangiare.setColonna((posPartenza.getColonna() - 1));
                        }
                        daMangiare = this.damieraGioco[posDaMangiare.getRiga()][posDaMangiare.getColonna()];
                        // Se c'è qualcosa di effettivo da mangiare
                        if (daMangiare != null && daMangiare.getColore() != coloreGiocatore) {
                            presaPossibile = true;
                            // se è una dama può mangiare tutto
                            if (contenutoPosPar.getTipo() == TipoPedina.pedinaRe) {
                                presaPossibileDamatura = true;
                                presaLecita = true;
                            } else {
                                // altrimenti non può mangiare la dama
                                if (daMangiare.getTipo() != TipoPedina.pedinaRe) {
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
        if (!posParValida) {
            System.out.println("Presa non valida. La casella di partenza è vuota");
        } else if (!posArrValida) {
            System.out.println("Presa non valida. La casella di arrivo non è vuota");
        } else if (!coloreGiusto) {
            System.out.println("Non puoi spostare una pedina del tuo avversario");
        } else if (!(rigaCorretta && colonnaCorretta)) {
            System.out.println("Movimento non lecito.");
        } else if (!presaPossibile) {
            System.out.println("Presa non possibile");
        } else if (!presaPossibileDamatura) {
            System.out.println("Non puoi mangiare una dama con una pedina semplice");
        }

        if (presaLecita) {
            this.damieraGioco[posDaMangiare.getRiga()][posDaMangiare.getColonna()] = null;
            this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()]
                    = this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()];
            this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()] = null;
            if (posArrivo.getRiga() == rigaBaseNemica) {
                System.out.println("Hai effettuato la damatura!");
                this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()].promuoviADama();
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

    public boolean effettuaPresaMultipla(final String mossa, final Colore coloreGiocatore) {
        boolean presaMultiplaLecita = false;

        int contatoreMosse = 0;
        String[] numeri = mossa.split("x");

        String[] prese = new String[numeri.length - 1];

        for (int i = 0; i < numeri.length - 1; i++) { // Tokenizzazine mosse
            prese[contatoreMosse] = String.join("x", numeri[i], numeri[i + 1]);
            contatoreMosse++;
        }

        // Backup damiera e dei contatori nel caso le mosse non siano legali
        Pedina[][] damieraBackup = new Pedina[DAMIERA_SIZE][DAMIERA_SIZE];
        int backupMangiateBianco = pedineBiancheMangiate;
        int backupMangiateNero = pedineNereMangiate;

        for (int i = 0; i < DAMIERA_SIZE; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
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
            //Se una delle mosse non era lecita, resetta la damiera com'era prima
            for (int i = 0; i < DAMIERA_SIZE; i++) {
                for (int j = 0; j < DAMIERA_SIZE; j++) {
                damieraGioco[i][j] = damieraBackup[i][j];
                }
            }
            this.pedineBiancheMangiate = backupMangiateBianco;
            this.pedineNereMangiate = backupMangiateNero;
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

    public void registraMosse(final String mossa, final Colore coloreGiocatore) {
        String mossaTotale;
        if (coloreGiocatore == Colore.bianco) {
            mossaTotale = "B. " + mossa;
        } else {
            mossaTotale = "N. " + mossa;
        }
        this.listaMosse.add(mossaTotale);
    }

    public void stampaMosse() {

        for (int i = 0; i < this.listaMosse.size(); i++) {
            System.out.println(listaMosse.get(i));
        }
    }
}
