/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vues;

import modeles.*;
import java.util.*;
import java.awt.event.*;

/**
 *
 * @author PC PRO ULTRA RAPIDE
 */
public class Vue{
    private Model m;
    private Scanner sc = new Scanner(System.in);

    public Vue(Model m) {
        this.m = m;
    }
    public void affMsg(String msg) {
        System.out.println(msg);
    }

    public String getMsg(String regex) {
        String msg = "";
        boolean ok = false;
        boolean flag = true;
        do {
            msg = sc.nextLine();
            if (m.verifier(regex, msg) == true) {
                ok = true;
                flag = false;
            }
            if(flag == true){
                System.out.println(m.erreurSaisie(regex));
            }
        } while (ok == false);
        return msg;
    }

    public String getMsg() {
        String msg;
        msg = sc.nextLine();
        return msg;
    }
    public void afficheCategorie(ArrayList<Categorie> cat)
    {
        for(Categorie ca : cat){
            System.out.println(ca.getId()+" - "+ca.getCategorie());
        }
    }
    public void afficheProsition(Proposition[] cat)
    {
        for(Proposition ca : cat){
            System.out.println(ca.getId()+" - "+ca.getPropos());
            
        }
    }
    public void afficheQuestion(ArrayList<Question> cat)
    {
        for(Question ca : cat){
            System.out.println(ca.getIdQuestion()+" - "+ca.getLibelle());
            
        }
    }
}
