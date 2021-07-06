/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeles;

/**
 *
 * @author PC PRO ULTRA RAPIDE
 */
public class Joueur {
    private int id;
    private String pseudo;
    private int score;
    private int nbreParti;
    private int scoreFinal;
    private static int nbreJoueure = 1;
    
    public Joueur(){
        
    }
    public Joueur(String pseu){
        pseudo = pseu;
        score = 0;
        nbreParti = 0;
        scoreFinal = 0;
        id = nbreJoueure;
        nbreJoueure++;
        
    }
    public int getId(){
         return id;
    }
    public int getScore(){
         return score;
    }
    public int getScoreFinal(){
         return scoreFinal;
    }
    public int getNbreParti(){
         return nbreParti;
    }
    public String getPseudo(){
         return pseudo;
    }
    public void setPseudo(String s){
         pseudo = s;
    }
    public void setScoreFinal(int s){
         scoreFinal = s;
    }
    public void setScore(int s){
         score = s;
    }
    
    
}
