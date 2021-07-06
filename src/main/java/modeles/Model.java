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

public class Model {
    private ArrayList<Question> listQuestions;
    private ArrayList<Categorie> listCategories;
    private HashSet<Joueur> listJoureurs;
    private ArrayList<Niveau> listNiveau;
    private HashSet<Proposition> listProposition;
    
    public Model(){
        listCategories = new ArrayList();
        listJoureurs = new HashSet<>();
        listProposition = new HashSet<>();
        listNiveau =  new ArrayList();
        listQuestions = new ArrayList();
    }
    public Boolean verifier(String regex, String msg) {
        if (msg.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<Question> questionCategorie(ArrayList<Question> ques, Categorie ca){
        ArrayList<Question> led = new ArrayList();
        for(Question q : ques){
            if(q.getIdCtegorie()== ca.getId()){
                led.add(q);
            }
        }  
        return led;
    }
    public Question creerQuestion(int id_categorie)
    {
        Question ques = new Question(id_categorie);
        return ques;
    }
    public void ajoutPropositionQuestion(Question ques,Proposition pro)
    {
        ques.ajoutProposition(pro);
    }
    public void reerQuestion(int idc,String lib,int nivo,Proposition rep){
        Question ques = new Question(idc, lib, nivo, rep);
        listQuestions.add(ques);
    }
    public void ajouterProposition(Proposition p)
    {
        listProposition.add(p);
    }
    public void ajouterCategorie(Categorie p)
    {
        listCategories.add(p);
    }
    public void reerNiveau(String intitule,int idCat,int nbrQues){
        Niveau niv = new Niveau(intitule, idCat, nbrQues);
        listNiveau.add(niv);
    }
    public Categorie creerCategorie(String ca){
        Categorie cat = new Categorie(ca);
        return cat;
    }
    public void reerJoueur(String lib){
        Joueur jou = new Joueur(lib);
        listJoureurs.add(jou);
    }
    public ArrayList<Categorie> getListCategorie()
    {
        return listCategories;
    }
    public ArrayList<Question> getListQuestion()
    {
        return listQuestions;
    }
    public HashSet<Proposition> getListProposition()
    {
        return listProposition;
    }
    public Proposition trouveProposition(HashSet<Proposition> liste,int id)
    {
        Proposition p = new Proposition();
        for(Proposition propo : liste){
            if(propo.getId()== id){
                p = propo;
            }
        }
        return p;
    }
    public void supprimerQuestion(Question ques){
        listQuestions.remove(ques);
    }
     public void supprimerNiveau(Niveau niv){
        listNiveau.remove(niv);
    }
    public void supprimerCategorie(Categorie cat){
        listCategories.remove(cat);
    }
     public void supprimerJoueur(Joueur joueur){
        listJoureurs.remove(joueur);
    }
    public boolean existeCategorie(ArrayList<Categorie> cat, String categorie){
        boolean drapeau = false;
        for(Categorie ca : cat){
            if(ca.getCategorie().equals(categorie)){
                drapeau = true;
            }
        }
        return drapeau;
    }
    public Categorie chercheCategorie(ArrayList<Categorie> cat, int idCat){
        Categorie c = new Categorie();
        for(Categorie categorie : cat){
            if(categorie.getId()==idCat){
                c = categorie;
            }
        }
        return c;
    }
    public String expressionReguliereNombre()
    {
       return "[0-9]+"; 
    }
    public String expressionReguliereQuestion()
    {
       return "[A-Z]{1}[a-z ,@]+[?]{1}"; 
    }
    public String expressionReguliereProposition()
    {
       return "[A-Z]{1}[a-z0-9 ,@]+[.]{1}"; 
    }
     public String expressionReguliereCategorie()
    {
       return "[A-Z]{1}[A-Za-z0-9 ,@]+"; 
    }
     public String erreurSaisie(String reg)
    {
        String test = "";
        if(reg.equals(expressionReguliereQuestion())){
            test =  "Une question commence par une lettre majuscule et se terminer par ? ";
        }else if(reg.equals(expressionReguliereProposition())){
            test =  "Une proposition commence par une lettre majuscule et se terminer par un point ";
        }else if(reg.equals(expressionReguliereCategorie())){
            test =  "Veuillez commence par une majuscule ";
        }else{
            test = "Veuillez entrer un nombre ";
        }
       return test ; 
    }
    
    
}
