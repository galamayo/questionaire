/*
 * La class proposition permet de connaitre les prositions faites
 * pour une question et la reponse à cette question.
 */
package modeles;

/**
 *
 * @author Patrick Galamayo
 */
public class Proposition {
    private int id;
    private String propos;
    private static int nbreProposition = 1;
    
    public Proposition( String pro)
    {
        this.id = nbreProposition;
        this.propos = pro;
        nbreProposition++;
    }
     public Proposition()
    {

    }
    public Proposition(Proposition p)
    {
        id = p.id;
        propos = p.propos;
    }
   
    public boolean equals(Object obj) 
    { 
       if (this == obj) return true; 
          if (obj == null) return false; 
        if (!(obj instanceof Proposition))return false; 
        Proposition other = (Proposition) obj; 
       if (propos == null) { 
            if (other.propos != null) return false; 
        } else if (!propos.equals(other.propos)) return false; 
        return true; 
    } 
    
    
    public int getId()
    {
      return id;  
    }
    public String getPropos(){
        return propos;
    }
    public void setPropos(String propo)
    {
        propos = propo;
    }
}
