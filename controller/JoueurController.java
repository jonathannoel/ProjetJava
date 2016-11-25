package controller;

import model.Joueur;
import view.JoueurView;

public class JoueurController {
   private Joueur model;
   private JoueurView view;

   public JoueurController(Joueur model, JoueurView view){
      this.model = model;
      this.view = view;
   }

   public void setJoueurName(String name){
      model.setName(name);		
   }

   public String getJoueurName(){
      return model.getName();		
   }

   public void updateView(){				
      view.printJoueurDetails(model.getName());
   }	
}
