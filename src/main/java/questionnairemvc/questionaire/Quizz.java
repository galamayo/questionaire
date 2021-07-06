/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionnairemvc.questionaire;

import controleurs.Controller;
import modeles.*;
import vues.Vue;

/**
 *
 * @author PC PRO ULTRA RAPIDE
 */
public class Quizz {
     private Controller controleur;
     private Model modele;
    private Vue vue;
 
     
     public Quizz() {
         modele = new Model();
        vue = new Vue(modele);
        controleur = new Controller(modele,vue);
        controleur.menu();    }    

    public static void main(String[] args) {
        Quizz mvc = new Quizz();
    }
    
}
