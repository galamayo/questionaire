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
import java.util.*;
public class Question {
    private int idQuestion;
    private int idCategorie;
    private String libelle;
    private ArrayList<Proposition> propositions;
    private int idNiveau;
    private Proposition reponse;
    private static int nbreQuestion = 1;
    
    public Question(int idC, String li, int idNivo, Proposition rep){
        idQuestion = nbreQuestion;
        idCategorie = idC;
        idNiveau = idNivo;
        libelle = li;
        reponse = rep;
        propositions = new ArrayList<>();
        nbreQuestion++;
    }
    public Question(){
      propositions = new ArrayList<>();  
    }
    public Question(int cat){
       idCategorie = cat;
       propositions = new ArrayList<>();
    }
    public Question(Question q){
        idQuestion = q.idQuestion;
        idCategorie = q.idCategorie;
        libelle = q.libelle;
        idNiveau = q.idNiveau;
        reponse = q.reponse;
    }
    public int getIdQuestion(){
        return idQuestion;
    }
    public int getIdCtegorie(){
        return idCategorie;
    }
    public String getLibelle(){
        return libelle;
    }
    public Proposition getReponse(){
        return reponse;
    }
    public void setIdQuestion(int id)
    {
        idQuestion = id;
    }
    public void setIdCategorie(int id)
    {
        idCategorie = id;
    }
    public void setIdNiveau(int id)
    {
        idNiveau = id;
    }
    public void setLibelle(String lib)
    {
        libelle = lib;
    }
    public void setReponse(Proposition lib)
    {
        reponse = lib;
    }
    public void ajoutProposition(Proposition propo)
    {
        propositions.add(propo);
    }
    public ArrayList<Proposition> getPropositions()
    {
        return propositions;
    }

    
}
