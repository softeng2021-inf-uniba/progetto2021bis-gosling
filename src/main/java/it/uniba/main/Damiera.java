package it.uniba.main;

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
        System.out.print("+---+---+---+---+---+---+---+---+\n");
        for(int i=0; i<8;i++)
        {
            System.out.print("|");
            for(int j=0; j<8;j++)
            {
                if(damieraNumeri[i][j] != 0)
                {
                    if(damieraNumeri[i][j]>9)
                    {
                        System.out.print("" + damieraNumeri[i][j]+ " ");
                    } else {
                        System.out.print(" " + damieraNumeri[i][j]+ " ");
                    }
                } else
                {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.print("\n");
            System.out.print("+---+---+---+---+---+---+---+---+");
            System.out.print("\n");
        }
    }
    
    public void stampaPedine()
    {
        
    }
}
