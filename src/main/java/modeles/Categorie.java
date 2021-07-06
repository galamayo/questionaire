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
public class Categorie {
    private int id;
    private String categorie;
    private static int nbreCategorie = 1;
    
    public Categorie(){
        
    }
     public Categorie( String li){
        id = nbreCategorie;
        categorie = li;
        nbreCategorie++;
        
     }
     public Categorie(Categorie n){
         id = n.id;
         categorie = n.categorie;
     }
     public int getId(){
         return id;
     }
     public String getCategorie(){
         return categorie;
     }
     public void setCategorie(String inti){
         categorie = inti;
     }
}
