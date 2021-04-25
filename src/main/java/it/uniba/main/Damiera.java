package it.uniba.main;

import it.uniba.main.types.Colore;
import it.uniba.main.types.Posizione;

/**
 *
 * @author Pasquale & Massimo
 */


public class Damiera {
    /* ------------ Stato ------------ */
    private static Damiera singleIstance; // Per rendere la classe singleton
    private final int[][] damieraNumeri;
    private final Pedina[][] damieraGioco;
    private final Posizione[] vettorePosizioni;
    
    /* ------------  Costruttori ------------ */
    private Damiera()
    {
        damieraGioco = new Pedina[8][8];
        damieraNumeri = new int[8][8];
        vettorePosizioni = new Posizione[32];
        int counter = 1;
        preparaVettore();
        preparaDamiera();
        for(int i=0; i<8; i++)
        {
            if(i%2==0)
            {
                for(int j=0;j<8;j++)
                {
                    if(j%2==0)
                    {
                        damieraNumeri[i][j] = counter;
                        counter++;  
                    } else
                    {
                        damieraNumeri[i][j] = 0;
                    }
                }
            } else 
            {
                for(int j=0;j<8;j++)
                {
                    if(j%2==1)
                    {
                        damieraNumeri[i][j] = counter;
                        counter++;  
                    } else
                    {
                        damieraNumeri[i][j] = 0;
                    }
                }
            }
        }
    }
    
    private void preparaVettore(){
        vettorePosizioni[0] = new Posizione(0,0);
        vettorePosizioni[1] = new Posizione(0,2);
        vettorePosizioni[2] = new Posizione(0,4);
        vettorePosizioni[3] = new Posizione(0,6);
        vettorePosizioni[4] = new Posizione(1,1);
        vettorePosizioni[5] = new Posizione(1,3);
        vettorePosizioni[6] = new Posizione(1,5);
        vettorePosizioni[7] = new Posizione(1,7);
        vettorePosizioni[8] = new Posizione(2,0);
        vettorePosizioni[9] = new Posizione(2,2);
        vettorePosizioni[10] = new Posizione(2,4);
        vettorePosizioni[11] = new Posizione(2,6);
        vettorePosizioni[12] = new Posizione(3,1);
        vettorePosizioni[13] = new Posizione(3,3);
        vettorePosizioni[14] = new Posizione(3,5);
        vettorePosizioni[15] = new Posizione(3,7);
        vettorePosizioni[16] = new Posizione(4,0);
        vettorePosizioni[17] = new Posizione(4,2);
        vettorePosizioni[18] = new Posizione(4,4);
        vettorePosizioni[19] = new Posizione(4,6);
        vettorePosizioni[20] = new Posizione(5,1);
        vettorePosizioni[21] = new Posizione(5,3);
        vettorePosizioni[22] = new Posizione(5,5);
        vettorePosizioni[23] = new Posizione(5,7);
        vettorePosizioni[24] = new Posizione(6,0);
        vettorePosizioni[25] = new Posizione(6,2);
        vettorePosizioni[26] = new Posizione(6,4);
        vettorePosizioni[27] = new Posizione(6,6);
        vettorePosizioni[28] = new Posizione(7,1);
        vettorePosizioni[29] = new Posizione(7,3);
        vettorePosizioni[30] = new Posizione(7,5);
        vettorePosizioni[31] = new Posizione(7,7);
    }
    /* ------------ Get & Set ------------*/
    
    public static Damiera getDamiera() // Serve ad ottenere damiera
    {
        if(singleIstance==null)
        {
            singleIstance = new Damiera();
        }
        
        return singleIstance;
    }   
    
    /* ------------ Metodi ------------*/
    public void stampaNumeri()
    {
        char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for(int i=0; i<8;i++)
        {
            System.out.print("|");
            for(int j=0; j<8;j++)
            {
                if(damieraNumeri[i][j] != 0)
                {
                    if(damieraNumeri[i][j]>9)
                    {
                        System.out.print(damieraNumeri[i][j]);
                        System.out.print(space);
                    } else {
                        System.out.print(space);
                        System.out.print(damieraNumeri[i][j]);
                        System.out.print(space);
                    }
                } else
                {
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
    
    public void preparaDamiera(){
       for(int i=0;i<3;i++){
           for(int j=0;j<8;j++){
               if(i%2==0){
                   if(j%2==0){
                      damieraGioco[i][j]=new Pedina(Colore.nero);
                   } else 
                   {
                       damieraGioco[i][j]=null;
                   }
               }
               else{
                   if(j%2==1){
                       damieraGioco[i][j]=new Pedina(Colore.nero);
                   }else
                   {
                       damieraGioco[i][j]=null;
                   }
               }
           }
       }
       for(int i=3;i<5;i++){
           for(int j=0;j<5;j++){
               damieraGioco[i][j]=null;
           }
       }
       for(int i=5;i<8;i++){
          for(int j=0;j<8;j++){
              if(i%2==0){
                   if(j%2==0){
                      damieraGioco[i][j]=new Pedina(Colore.bianco);
                   } else
                   {
                       damieraGioco[i][j]=null;
                   }
               }
               else{
                   if(j%2==1){
                       damieraGioco[i][j]=new Pedina(Colore.bianco);
                   } else
                   {
                       damieraGioco[i][j]=null;
                   }
               }
          } 
       }
    }
    
    public void stampaPedine()
    {
        // System.out.println("+-──-+-──-+-──-+-──-+-──-+-──-+-──-+-──-+");

        char space = '\u0020';
        System.out.println("+---+---+---+---+---+---+---+---+");
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(damieraGioco[i][j]!=null){
                    System.out.print("|" + space);
                    damieraGioco[i][j].stampaPedina();
                    System.out.print("" + space);
                }
                else{
                    System.out.print("|" + space + '\u2003' + space);
                }                       
            }
            System.out.println("|");
            System.out.println("+---+---+---+---+---+---+---+---+");
        }
    }
    
    public Posizione convertiPosizione(int pos){
        return this.vettorePosizioni[pos-1];
    }
    
    public boolean spostaPedina(String answer){
        boolean corretta = false;
        String[] numeri = answer.split("-");
        int numPartenza = Integer.valueOf(numeri[0]);
        int numArrivo = Integer.valueOf(numeri[1]);
        Posizione posPartenza = convertiPosizione(numPartenza);
        Posizione posArrivo = convertiPosizione(numArrivo);
        //inserire i controolli per eseguire lo spostamento
        corretta=true;
        if(corretta){
            this.damieraGioco[posArrivo.riga][posArrivo.colonna] = this.damieraGioco[posPartenza.riga][posPartenza.colonna];
            this.damieraGioco[posPartenza.riga][posPartenza.colonna] = null;
        }
        return corretta;
    }
}
