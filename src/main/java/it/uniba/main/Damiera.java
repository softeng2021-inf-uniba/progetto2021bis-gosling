package it.uniba.main;

import it.uniba.main.types.Colore;

/**
 *
 * @author Pasquale & Massimo
 */


public class Damiera {
    /* ------------ Stato ------------ */
    private static Damiera singleIstance; // Per rendere la classe singleton
    private final int[][] damieraNumeri;
    private final Pedina[][] damieraGioco;
    
    
    /* ------------  Costruttori ------------ */
    private Damiera()
    {
        damieraGioco = new Pedina[8][8];
        damieraNumeri = new int[8][8];
        int counter = 1;
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
}
