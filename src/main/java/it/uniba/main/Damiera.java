package it.uniba.main;

/**
 *
 * @author Pasquale & Massimo
 */


public class Damiera {
    private static Damiera singleIstance; // Per rendere la classe singleton
    
    
    private Damiera()
    {
        
    }
    
    public static Damiera getDamiera() // Serve ad ottenere damiera
    {
        if(singleIstance==null)
        {
            singleIstance = new Damiera();
        }
        
        return singleIstance;
    }   
}
