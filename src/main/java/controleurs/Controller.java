/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import java.util.*;
import modeles.*;
import vues.Vue;
/**
 *
 * @author PC PRO ULTRA RAPIDE
 */
public class Controller {
    
    protected Model mode;
    protected Vue vu;
    private String nom;
    
    public Controller(Model model, Vue vue) {
        mode = new Model();
        vu = new Vue(mode);
    }
    
    public void menu() {
        int choix;
        String menu = "\n1. Ajouter une question \n2. Lister\n3.Rechercher\n4. Quitter";
        do {
            vu.affMsg("Choisissez : ");
            vu.affMsg(menu);
            choix = Integer.parseInt(vu.getMsg("[1-4]"));
            switch (choix) {
                case 1:creationQuestion(); break;
                case 2:creationQuesionnaire(); break;
                    
                case 3:
                    break;
                case 4:
                    vu.affMsg("Fin du pgm");
                    break;
            }
        } while (choix != 4);
    }
    /*
    *Cette fonction nous permet de créer un questionnaire avec des questions qui appartiennent
    *à la même categorie
    */
    public void creationQuesionnaire(){
        ArrayList<Categorie> cat = mode.getListCategorie();
        ArrayList<Question> ques = mode.getListQuestion();
        int nbreQuestion = ques.size();
        int nbreCategorie = cat.size();
        if(nbreCategorie == 0 || nbreQuestion < 5){
           vu.afficheCategorie(cat);
           vu.affMsg("Veuillez choisir une categorie : ");
           int flag = Integer.parseInt(vu.getMsg(mode.expressionReguliereNombre()));
           Categorie categorie = mode.chercheCategorie(cat, flag);
           ArrayList<Question> questionCategorie = mode.questionCategorie(ques, categorie);
            //creationQuestion();
        }else{
           vu.afficheCategorie(cat);
           vu.affMsg("Veuillez choisir une categorie : ");
           int flag = Integer.parseInt(vu.getMsg(mode.expressionReguliereNombre()));
        }
        
       
        
        
     
    }
    /*
    *Cette fonction nous permet de créer une question avec ses diffèrentes propositions
    *et donner une reponse à celui-ci tout en précisant la catégorie de la question.
    */
    public void creationQuestion()
    {
        
        ArrayList<Categorie> cat = mode.getListCategorie();
        String categorie = "";
        if (cat.size()== 0){
            boolean ok = true;
            vu.affMsg("Veuillez entrer une categorie : ");
            categorie = vu.getMsg(mode.expressionReguliereCategorie());
           Categorie cate = mode.creerCategorie(categorie);
           mode.ajouterCategorie(cate);
            initQuestion(cate.getId());
          
        }else{
            int nbreCat = cat.size();
            vu.affMsg("Voulez-vous ajouter une categorie : O/N ");
            String decision = vu.getMsg("[O|N]");
            if(decision.equals("O")){
                boolean ok = true;
                do{
                   vu.affMsg("Veuillez entrer une categorie : ");
                   categorie = vu.getMsg(mode.expressionReguliereCategorie());
                   ok = mode.existeCategorie(cat, categorie);
                }while(ok == true);
                Categorie cate1 = mode.creerCategorie(categorie);
                mode.ajouterCategorie(cate1);
                initQuestion(cate1.getId());
               
            }else{
            vu.affMsg("Veuillez choisir une categorie : ");
            vu.afficheCategorie(cat);
            int flag = Integer.parseInt(vu.getMsg("[1-"+nbreCat+1+"]"));
                initQuestion(flag); 
            }   
        }
    }
    private void initQuestion(int idCategorie)
    {
        Question question = mode.creerQuestion(idCategorie);
       vu.affMsg("Veuillez choisir un niveau entre 1 et 3 : ");
       String niveau = vu.getMsg("[1-3]");
            int idNivo = Integer.parseInt(niveau);
            question.setIdNiveau(idNivo);
            vu.affMsg("Veuillez saisir la question et terminer par ? : ");
            String libele = vu.getMsg(mode.expressionReguliereQuestion());
            question.setLibelle(libele);
            Proposition[] propos = new Proposition[4];
            vu.affMsg("Veuillez saisir la proposition 1 : ");
            String pro1 = vu.getMsg(mode.expressionReguliereProposition());
            Proposition prop1 = new Proposition(pro1);
            mode.ajoutPropositionQuestion(question, prop1);
            mode.ajouterProposition(prop1);
            propos[0] = prop1;
            vu.affMsg("Veuillez saisir la proposition 2 : ");
            String pro2 = vu.getMsg(mode.expressionReguliereProposition());
            Proposition prop2 = new Proposition(pro2);
            mode.ajoutPropositionQuestion(question, prop2);
            mode.ajouterProposition(prop2);
            propos[1] = prop2;
            vu.affMsg("Veuillez saisir la proposition 3 : ");
            String pro3 = vu.getMsg(mode.expressionReguliereProposition());
            Proposition prop3 = new Proposition(pro3);
            mode.ajoutPropositionQuestion(question, prop3);
            mode.ajouterProposition(prop3);
            propos[2] = prop3;
            vu.affMsg("Veuillez saisir la proposition 4 : ");
            String pro4 = vu.getMsg(mode.expressionReguliereProposition());
            Proposition prop4 = new Proposition(pro4);
            mode.ajoutPropositionQuestion(question, prop4);
            mode.ajouterProposition(prop4);
            propos[3] = prop4;
            vu.afficheProsition(propos);
            vu.affMsg("Choisir la reponse : ");
            int rep = Integer.parseInt(vu.getMsg("[1-4]"));
            HashSet<Proposition> listePropo = mode.getListProposition();
            Proposition reponse = propos[rep-1];
            question.setReponse(reponse);
            
    }
     
    
}
