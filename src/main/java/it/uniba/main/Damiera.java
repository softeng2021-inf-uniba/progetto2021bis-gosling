package it.uniba.main;

import it.uniba.main.eccezioni.eccezionePresa;
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

    /**
    * Tipo Classe: <<Entity>>
    * 
    * Registra le informazioni di una posizione
    * 
    */
    public static final class Posizione {
    /* ------------ Stato ------------ */
        private int riga;
        private int colonna;
        /* ------------ Costruttori ------------ */
        public Posizione() {
        }
        public Posizione(final int rigaIn, final int colonnaIn) {
            this.riga = rigaIn;
            this.colonna = colonnaIn;
        }
        /* ------------ Get & Set ------------ */
        public int getRiga() {
            return riga;
        }

        public int getColonna() {
            return colonna;
        }

        public void setRiga(final int rigaIn) {
            this.riga = rigaIn;
        }

        public void setColonna(final int colonnaIn) {
            this.colonna = colonnaIn;
        }
    }
    /* ------------  Costruttori ------------ */
    private Damiera()  {
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

    public static Posizione convertiNumeroInPosizione(final int num) {
        Posizione posizioneDesiderata;
        
        if (num >= 1 && num <= 32) {
            posizioneDesiderata = VETTORE_POSIZIONI[num - 1];
        } else {
            posizioneDesiderata = new Posizione(-1, -1);
        }
        
        return posizioneDesiderata;
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
                        damieraGioco[i][j] = new Pedina(Pedina.Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 != 0) {
                        damieraGioco[i][j] = new Pedina(Pedina.Colore.nero);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                }
            }
        }
        for (int i = primaParte; i < secondaParte; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
                damieraGioco[i][j] = null;
            }
        }
        for (int i = secondaParte; i < DAMIERA_SIZE; i++) {
            for (int j = 0; j < DAMIERA_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        damieraGioco[i][j] = new Pedina(Pedina.Colore.bianco);
                    } else {
                        damieraGioco[i][j] = null;
                    }
                } else {
                    if (j % 2 != 0) {
                        damieraGioco[i][j] = new Pedina(Pedina.Colore.bianco);
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

    public boolean spostamentoPedina(final String mossa, final Pedina.Colore coloreGiocatore) {

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
        if (coloreGiocatore == Pedina.Colore.bianco) {
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

                if (contenutoPosPar.getTipo() == Pedina.TipoPedina.pedinaSemplice) {
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

            Pedina contenutoPosArrivo = this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()];
            
            // Aggiungi la mossa all'elenco di mosse
            if (posArrivo.getRiga() == rigaBaseNemica && contenutoPosArrivo.getTipo() != Pedina.TipoPedina.pedinaRe) {
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

    public boolean effettuaPresaSemplice(final String mossa, final Pedina.Colore coloreGiocatore) throws eccezionePresa {
        boolean presaLecita = false;
        boolean rigaCorretta = false;
        boolean colonnaCorretta = false;

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
        if (coloreGiocatore == Pedina.Colore.bianco) {
            versoAvanzamento = -1;
            rigaBaseNemica = 0;
        } else {
            versoAvanzamento = 1;
            rigaBaseNemica = DAMIERA_SIZE - 1;
        }
        // Se la posizione di partenza non è vuota
        if (contenutoPosPar != null) { 
            // e il colore è quello giusto
            if (contenutoPosPar.getColore() == coloreGiocatore) {
                // se lo spostamento non va in una casella già piena
                if (contenutoPosArr == null) {
                    // Se è una pedina semplice, verifico che sia corretta
                    if (contenutoPosPar.getTipo() == Pedina.TipoPedina.pedinaSemplice) {
                        rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento * 2));
                    } else {
                        rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento * 2)
                                || posArrivo.getRiga() == (posPartenza.getRiga() - versoAvanzamento * 2));
                    }

                    colonnaCorretta = (posArrivo.getColonna() == (posPartenza.getColonna() - 2)
                            || posArrivo.getColonna() == (posPartenza.getColonna() + 2));
                    // se la mossa è valid
                    if (rigaCorretta && colonnaCorretta) {
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
                        // Se c'è una pedina nella casella da mangiare ed è del colore giusto
                        if (daMangiare != null && daMangiare.getColore() != coloreGiocatore) {
                            // se è una dama può mangiare tutto
                            if (contenutoPosPar.getTipo() == Pedina.TipoPedina.pedinaRe) { // se a spostarsi è una dama può mangiare tutto
                                presaLecita = true;
                            } else { 
                                // altrimenti non può mangiare la dama
                                if (daMangiare.getTipo() != Pedina.TipoPedina.pedinaRe) {
                                    presaLecita = true;
                                } else { 
                                    // Non puoi mangiare
                                    throw new eccezionePresa("Non puoi mangiare una dama con una pedina semplice");
                                }
                            } 
                        } else { 
                            // Da mangiare == null o il colore della pedina mangiata è la stessa
                            throw new eccezionePresa("Presa non possibile");
                        }
                    } else { 
                        // riga o colonna non corretta
                        throw new eccezionePresa("Movimento non lecito.");
                    }
                } else {
                    // Casella di arrivo non vuota
                    throw new eccezionePresa("Presa non valida. La casella di arrivo non è vuota");
                } 
            } else {
                // casella spostata dell'avversario
                throw new eccezionePresa("Non puoi spostare una pedina del tuo avversario");
            }
        } else {
            // Casella di partenza vuota
            throw new eccezionePresa("Presa non valida. La casella di partenza è vuota");
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
            if (coloreGiocatore == Pedina.Colore.bianco) {
                incrementaPreseNere();
            } else {
                incrementaPreseBianche();
            }
        }

        return presaLecita;
    }

    public boolean effettuaPresaMultipla(final String mossa, final Pedina.Colore coloreGiocatore) throws eccezionePresa {
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
            System.out.print('\u26C2' + " ");
        }
        System.out.print("\nBianco: ");
        for (int i = 0; i < pedineNereMangiate; i++) {
            System.out.print('\u26C0' + " ");
        }

        System.out.println("");
    }

    public void registraMosse(final String mossa, final Pedina.Colore coloreGiocatore) {
        String mossaTotale;
        if (coloreGiocatore == Pedina.Colore.bianco) {
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
