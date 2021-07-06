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
public class Niveau {
    private int id;
    private String intitule;
    private int idCategorie;
    private int nbreQuestion;
    private static int nbreNivo = 1;
    
    public Niveau(){
        
    }
     public Niveau( String li, int cat, int nbQuestion){
        id = nbreNivo;
        intitule = li;
        idCategorie = cat;
        nbreQuestion = nbQuestion;
        nbreNivo++;
        
     }
     public Niveau(Niveau n){
         id = n.id;
         intitule = n.intitule;
         idCategorie = n.idCategorie;
     }
     public int getId(){
         return id;
     }
     public int getIdCategorie(){
         return idCategorie;
     }
     public int getNbreQuestion(){
         return nbreQuestion;
     }
     public void getIdCategorie(int cat){
         idCategorie = cat;
     }
     public String getIntitule(){
         return intitule;
     }
     public void setIntitule(String inti){
         intitule = inti;
     }
     public void setNbreQuestion(int inti){
         nbreQuestion = inti;
     }
    
}
