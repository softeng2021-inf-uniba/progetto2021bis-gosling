package it.uniba.main.dati;

import it.uniba.main.eccezioni.EccezionePresa;
import it.uniba.main.eccezioni.EccezioneSpostamento;
import java.util.ArrayList;
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
    /**
     * Indica il numero di possibili posizioni all'interno di una damiera.
     */
    private static final int GRANDEZZA_POSIZIONI = 32;
    /**
     * Indica la grandezza di una damiera con numeri e la damiera di gioco.
     */
    private static final int DAMIERA_SIZE = 8;
    /**
     * Un vettore utilizzato per la traduzione da numero intero in posizione all'interno della matrice damieraGioco.
     */
    private static final Posizione[] VETTORE_POSIZIONI = new Posizione[GRANDEZZA_POSIZIONI];
    private static Damiera singleIstance = null;  // Per rendere la classe singleton
    /**
     * Una matrice che viene usata per la stampa della damiera numerata.
     */
    private final int[][] damieraNumeri;
    /**
     * Una matrice di pedine utilizzata per simulare una damiera per una partita a dama.
     */
    private Pedina[][] damieraGioco;
    /**
     * Un contatore che viene incremento ogni qual volta che una pedina di colore nero viene mangiata.
     */
    private int pedineNereMangiate;
    /**
     * Un contatore che viene incremento ogni qual volta che una pedina di colore nero viene mangiata.
     */
    private int pedineBiancheMangiate;
    /**
     * Una lista in cui vengono inserite tutte le mosse inseriti dai due giocatori.
     */
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
        /**
         * Il costruttore di Posizione senza parametri di input
         */
        public Posizione() {
        }

        /**
         * Il costruttore di Posizione che inizializza sia la riga che la colonna.
         * 
         * @param rigaIn è l'intero che verra assegnato alla riga
         * @param colonnaIn è l'intero che verra assegnato alla colonna
         */
        public Posizione(final int rigaIn, final int colonnaIn) {
            this.riga = rigaIn;
            this.colonna = colonnaIn;
        }

        /* ------------ Get & Set ------------ */
        /**
         * Restituisce la riga.
         * 
         * @return è la riga dell'oggetto posizione
         */
        public int getRiga() {
            return riga;
        }

        /**
         * Restituisce la colonna.
         * 
         * @return è la colonna dell'oggeto posizione
         */
        public int getColonna() {
            return colonna;
        }

        /**
         * Imposta la riga secondo un parametro in input.
         * 
         * @param rigaIn è l'intero che verrà assegnato a riga 
         */
        public void setRiga(final int rigaIn) {
            this.riga = rigaIn;
        }

        /**
         * Imposta un nuovo valore alla colonna secondo un parametro in input.
         * 
         * @param colonnaIn è l'intero che verrà assegnato a colonna
         */
        public void setColonna(final int colonnaIn) {
            this.colonna = colonnaIn;
        }
    }

    /* ------------  Costruttori ------------ */
    /**
     * Il costruttore di Damiera che inizializza tutti i suoi attributi.
     */
    private Damiera() {
        Damiera.inizializzaVettorePosizioni();
        this.damieraNumeri = new int[DAMIERA_SIZE][DAMIERA_SIZE];
        this.damieraGioco = new Pedina[DAMIERA_SIZE][DAMIERA_SIZE];
        preparaNumeri();
        preparaDamiera();
        this.pedineNereMangiate = 0;
        this.pedineBiancheMangiate = 0;
        this.setListaMosse(new ArrayList<>());
    }

    /* ------------ Get & Set ------------*/
    /**
     * Controlla se esiste già un istanza di damiera, in caso negativo ne crea una nuova e la restituisce, altrimenti restituisce quella gia esistente.
     * 
     * @return è la damiera che restituisce il metodo
     */
    public static Damiera getDamiera() { // Serve ad ottenere damiera
        if (singleIstance == null) {
            singleIstance = new Damiera();
        }
        return singleIstance;
    }

    /**
     * Restituisce la lista listaMosse della Damiera.
     * 
     * @return è la lista che restituisce il metodo
     */
    public List<String> getListaMosse() {
        return listaMosse;
    }

    /**
     * Imposta un nuovo valore a listaMosse secondo un parametro di input.
     * 
     * @param listaMosseIn è la lista che verra assegnata a listaMosse
     */
    public void setListaMosse(final List<String> listaMosseIn) {
        this.listaMosse = listaMosseIn;
    }

    /**
     * Restituisce il numero massimo di posizioni.
     * 
     * @return è l'intero che indica il numero massimo di posizioni
     */
    public static int getGrandezzaPosizioni() {
        return GRANDEZZA_POSIZIONI;
    }

    /**
     * Restituisce la grandezza della damiera.
     * 
     * @return è l'intero che indica la grandezza della matrice damiera
     */
    public static int getDamieraSize() {
        return DAMIERA_SIZE;
    }

    /* ------------ Metodi ------------*/

    /* -- Preparazione --*/
    
    /**
     * Viene chiamato nel costruttore di Damiera e serve a inizializzare il VETTORE_POSIZIONI.
     */
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

    
    /**
     * Viene chiamato qunado si vuole inizializzare la damieraGioco mettendo le 24 pedine semplici nelle posizioni di partenza,
     * rispettivamente bianche da 21 a 32 e nere da 1 a 12, invece le celle vuote vengono inpostate a null.
     * <p>
     * Inoltre questo metodo inizializza la listaMosse, le pedineBiancheMangiate e le pedineNereMangiate.
     * </p>
     */
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

    /**
     * Prepara la matrice damieraNumeri inserendo nelle apposite celle le posizioni corrispondenti sulla damiera.
     */
    public void preparaNumeri() {
        int counter = 1;
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
    }

    /**
     * Converte un numero della damiera da 1 a 32 in una posizione sulla matrice damieraGioco
     * 
     * @param num è il nuemro intero che riechiede il metodo per essere eseguito, esso servira per trovare la posizione corrispettiva a esso nella damiera
     * @return è la posizione corrispettiva trovata nel VETTORE_POSIZIONI
     */
    public static Posizione convertiNumeroInPosizione(final int num) {
        Posizione posizioneDesiderata;

        if (num >= 1 && num <= GRANDEZZA_POSIZIONI) {
            posizioneDesiderata = VETTORE_POSIZIONI[num - 1];
        } else {
            posizioneDesiderata = new Posizione(-1, -1);
        }

        return posizioneDesiderata;
    }

    /* -- Stampa --*/
    /**
     * Stampa la damieraNumeri, facendo visualizzare la damiera con le celle nuemerate
     */
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

    /**
     * Stampa la damieraGioco, facendo visualizzare tutte le pedine, sia bianche che nere, nelle celle in cui si trovano al momento in cui avviene
     * la chiamata del metodo.
     */
    public void stampaPedine() {
        // System.out.println("+-â”€â”€-+-â”€â”€-+-â”€â”€-+-â”€â”€-+-â”€â”€-+-â”€â”€-+-â”€â”€-+-â”€â”€-+");

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

    /**
     * Visualizza le pedine binache mangiate dal nero e le pedine nere mangiate dal bianco.
     */
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

    /**
     * Stampa tutte le mosse eseguite durante la partita, sia dal giocatore bianco che dal giocatore nero.
     */
    public void stampaMosse() {

        System.out.println("Lista mosse:");
        for (int i = 0; i < this.listaMosse.size(); i++) {
            System.out.println(listaMosse.get(i));
        }
    }

    /* -- Movimento --*/
    /**
     * Il metodo trasforma la mossa dell'utente in una coppia di numeri interi che simboleggiano la posizione di arrivo e la posizione di partenza, 
     * conevertendo in seguito, grazie al metodo convertiNumeroInPosizione, i due nemri in due posizioni.
     * <p>
     * Succesivamente controlla che la posizioni ottenute siano corrette, infatti verifica se nella cella di partenza è presente una pedina dello
     * stesso colore del giocatore che ha inserito il comando. Se è possibile arrivare alla cella di arrivo dalla cella di partenza e 
     * se la cella di arrivo è vuota. 
     * Nel caso in cui una di queste condizioni è falsa la mossa non viene eseguita e viene lanciata un' eccezione.
     * </p>
     * <p>
     * Invece nel caso in cui tutte le condizioni sono vere viene effettuato un altro controllo, ovvero, se la cella di arrivo fa parte della base
     * avversaria e la pedina spostata è una pedina semplice, viene effettuato lo spostamento e la pedina viene promossa a dama. 
     * Invece se la pedina spostata è una dama o la cella di arrivo non fa parte della base avversaria viene effettutao semplicemente lo spostamento.
     * </p>
     * 
     * @param mossa è la stringa del comando inserito dall'utente da esaminare e da eseguire nel caso sia corretta
     * @param coloreGiocatore è il colore del giocatore che ha inserito il comando 
     * @return il valore booleano indica la corretta esecuzione dello spostamento, restituisce true se lo spostamento è andato a buon fine, 
     * false altrimenti
     * @throws EccezioneSpostamento è l'eccezione che viene lanciata quando metodo riceve in input una mossa non corretta
     */
    public boolean spostamentoPedina(final String mossa, final Pedina.Colore coloreGiocatore)
            throws EccezioneSpostamento {

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
            } else {
                throw new EccezioneSpostamento("Colore della pedina sbagliato");
            }
        } else {
            if (contenutoPosPar == null && contenutoPosArr != null) {
                throw new EccezioneSpostamento("Casella di partenza nulla e di arrivo piena");
            } else if (contenutoPosPar == null) {
                throw new EccezioneSpostamento("Casella di partenza vuota");
            } else {
                throw new EccezioneSpostamento("Casella di arrivo piena");
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
            System.out.println("Mossa non valida.");
        }

        return spostamentoLecito;
    }

    /**
     * Il metodo trasforma la mossa dell'utente in una coppia di numeri interi che simboleggiano la posizione di arrivo e la posizione di partenza, 
     * conevertendo in seguito, grazie al metodo convertiNumeroInPosizione, i due nemri in due posizioni.
     * <p>
     * Succesivamente controlla che le posizioni ottenute siano corrette, infatti verifica se nella cella di partenza è presente una pedina dello
     * stesso colore del giocatore che ha inserito il comando. Se è possibile arrivare alla cella di arrivo dalla cella di partenza, se la cella 
     * di arrivo è vuota e se la pedina che l'utente vuole mangiare è una pedina avversaria. Nel caso in cui una di queste condizioni è falsa 
     * la mossa non viene eseguita e viene lanciata un' eccezione.
     * </p>
     * <p>
     * Invece nel caso in cui tutte le condizioni sono vere viene effettuato un altro controllo, ovvero, se la cella di arrivo fa parte della base
     * avversaria e la pedina spostata è una pedina semplice, viene effettuata la presa e la pedina viene promossa a dama. 
     * Invece se la pedina spostata è una dama o la cella di arrivo non fa parte della base avversaria viene effettutao semplicemente la presa.
     * In entrambi i casi viene incrementato di uno il contatore delle pedine mangiate del colore del giocatore che ha inserito la mossa.
     * </p>
     * 
     * @param mossa è la stringa del comando inserito dall'utente da esaminare e da eseguire nel caso sia corretta
     * @param coloreGiocatore  è il colore del giocatore che ha inserito il comando
     * @return il valore booleano indica la corretta esecuzione della presa, restituisce true se la presa è andata a buon fine, 
     * false altrimenti
     * @throws EccezionePresa  è l'eccezione che viene lanciata quando metodo riceve in input una mossa non corretta
     */
    public boolean effettuaPresaSemplice(final String mossa, final Pedina.Colore coloreGiocatore)
            throws EccezionePresa {
        boolean presaLecita = false;
        boolean rigaCorretta;
        boolean colonnaCorretta;

        String[] numeri = mossa.split("x");

        Posizione posPartenza = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[0]));
        Posizione posArrivo = Damiera.convertiNumeroInPosizione(Integer.parseInt(numeri[1]));

        Pedina contenutoPosPar = this.damieraGioco[posPartenza.getRiga()][posPartenza.getColonna()];

        Pedina contenutoPosArr = this.damieraGioco[posArrivo.getRiga()][posArrivo.getColonna()];

        // ci serve che sia fuori dagli if perchÃ© nello spostamento Ã¨ importante
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
        // Se la posizione di partenza non Ã¨ vuota
        if (contenutoPosPar != null) {
            // e il colore Ã¨ quello giusto
            if (contenutoPosPar.getTipo() == Pedina.TipoPedina.pedinaSemplice) {
                if (contenutoPosPar.getColore() == coloreGiocatore) {
                    // se lo spostamento non va in una casella giÃ  piena
                    if (contenutoPosArr == null) {
                        // Se Ã¨ una pedina semplice, verifico che sia corretta
                        rigaCorretta = (posArrivo.getRiga() == (posPartenza.getRiga() + versoAvanzamento * 2));
                        colonnaCorretta = (posArrivo.getColonna() == (posPartenza.getColonna() - 2)
                                || posArrivo.getColonna() == (posPartenza.getColonna() + 2));
                        // se la mossa Ã¨ valid
                        if (rigaCorretta && colonnaCorretta) {
                            posDaMangiare.setRiga((posPartenza.getRiga() + 1 * versoAvanzamento));
                            /*
                            Quando implementeremo gli spostamenti della dama, il controllo sulla riga andrÃ  svolto.
                             */
                            if (posArrivo.getColonna() > posPartenza.getColonna()) {
                                posDaMangiare.setColonna((posPartenza.getColonna() + 1));
                            } else {
                                posDaMangiare.setColonna((posPartenza.getColonna() - 1));
                            }
                            daMangiare = this.damieraGioco[posDaMangiare.getRiga()][posDaMangiare.getColonna()];
                            // Se c'Ã¨ una pedina nella casella da mangiare ed Ã¨ del colore giusto
                            if (daMangiare != null && daMangiare.getColore() != coloreGiocatore) {
                                // se Ã¨ una dama puÃ² mangiare tutto
                                // altrimenti non puÃ² mangiare la dama
                                if (daMangiare.getTipo() != Pedina.TipoPedina.pedinaRe) {
                                    presaLecita = true;
                                } else {
                                    // Non puoi mangiare
                                    throw new EccezionePresa("Non puoi mangiare una dama con una pedina semplice");
                                }
                            } else {
                                // Da mangiare == null o il colore della pedina mangiata Ã¨ la stessa
                                throw new EccezionePresa("Presa non possibile");
                            }
                        } else {
                            // riga o colonna non corretta
                            throw new EccezionePresa("Movimento non lecito.");
                        }
                    } else {
                        // Casella di arrivo non vuota
                        throw new EccezionePresa("Presa non valida. La casella di arrivo non Ã¨ vuota");
                    }
                } else {
                    // casella spostata dell'avversario
                    throw new EccezionePresa("Non puoi spostare una pedina del tuo avversario");
                }
            } else {
                throw new EccezionePresa("La presa con dama non Ã¨ stata implementata");
            }
        } else {
            // Casella di partenza vuota
            throw new EccezionePresa("Presa non valida. La casella di partenza Ã¨ vuota");
        }

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

        return presaLecita;
    }

    /**
     * Il metodo trasforma la mossa dell'utente in n prese semplici, poi salva lo stato della damieraGioco, lo stato delle pedineBiancheMangiate 
     * e lo stato delle pedineNereMangiate prima dell'inizio delle esesecuzioni delle prese.
     * Durante l'esecuzione delle prese semolici se una delle prese semplici fallisce, falliscono automaticamente l'intero comando e quindi la damiera
     * torna allo stato iniziale dell'esecuzione. Nel caso in cui sono tutte corrette, la prese multipla viene eseguita.
     * 
     * @param mossa è la stringa del comando inserito dall'utente da esaminare e da eseguire nel caso sia corretta
     * @param coloreGiocatore è il colore del giocatore che ha inserito il comando
     * @return il valore booleano indica la corretta esecuzione della presa multipla, restituisce true se la presa multipla è andata a buon fine, 
     * false altrimenti
     * @throws EccezionePresa è l'eccezione che viene lanciata quando metodo riceve in input una mossa non corretta
     */
    public boolean effettuaPresaMultipla(final String mossa, final Pedina.Colore coloreGiocatore)
            throws EccezionePresa {
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

        try {
            while (contaTestPrese < prese.length) { // Per ogni mossa, verifica se Ã¨ lecita
                presaMultiplaLecita = effettuaPresaSemplice(prese[contaTestPrese], coloreGiocatore);
                contaTestPrese++;
            }
        } catch (EccezionePresa exc) {
            presaMultiplaLecita = false;
            //Se una delle mosse non era lecita, resetta la damiera com'era prima
            for (int i = 0; i < DAMIERA_SIZE; i++) {
                for (int j = 0; j < DAMIERA_SIZE; j++) {
                    damieraGioco[i][j] = damieraBackup[i][j];
                }
            }
            this.pedineBiancheMangiate = backupMangiateBianco;
            this.pedineNereMangiate = backupMangiateNero;
            throw exc;
        }
        return presaMultiplaLecita;
    }

    /* -- Aggiornamento stato --*/
    /**
     * Incrementa di uno il valore delle pedineBiancheMnagiate
     */
    public void incrementaPreseBianche() {
        this.pedineBiancheMangiate++;
    }

    /**
     * Incrementa di uno il valore delle pedineNereMangiate
     */
    public void incrementaPreseNere() {
        this.pedineNereMangiate++;
    }

    /**
     * Inserisce la stringa mossa all'interno della lista listaMosse.
     * 
     * @param mossa è la stringa che bisogna inserire all'interno della lista listaMosse
     * @param coloreGiocatore è il colore del giocatore che ha inserito il comando
     */
    public void registraMossa(final String mossa, final Pedina.Colore coloreGiocatore) {
        String mossaTotale;
        if (coloreGiocatore == Pedina.Colore.bianco) {
            mossaTotale = "B. " + mossa;
        } else {
            mossaTotale = "N. " + mossa;
        }
        this.listaMosse.add(mossaTotale);
    }
}
