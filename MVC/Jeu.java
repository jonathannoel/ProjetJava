package MVC;

import java.util.Scanner;

import model.Bateau;
import controller.CarteController;
import controller.InteractionController;
import controller.JoueurController;
import model.Carte;
import model.InteractionsUtilisateur;
import model.Joueur;
import view.CarteView;
import view.InteractionView;
import view.JoueurView;

public class Jeu {
	public static void main(String[] args) throws InterruptedException {
		Scanner reader = new Scanner(System.in);
		Bateau[] bateaux;
		int input = 0;
		/*----------USER-----------*/
		//fetch student record based on his roll no from the database
		Joueur joueurModel  = retriveJoueurFromDatabase();
		//Create a view : to write student details on console
		JoueurView joueurView = new JoueurView();
		JoueurController joueurController = new JoueurController(joueurModel, joueurView);
		
		/*--------- MAP -------*/
		Carte carteModel = new Carte();
		CarteView carteView = new CarteView();
		CarteController carteController = new CarteController(carteModel,carteView);
		joueurController.updateView();
		/** for(int i = 3; i > 0; i--){
			System.out.println("le jeu va commencer dans : " + i);
			Thread.sleep(1000);
		} **/
		carteModel.setUser(joueurModel.getName());
		carteController.updateView();
		
		/*----------Interaction Utilisateur --------*/
		InteractionsUtilisateur iuModel = new InteractionsUtilisateur();
		InteractionView iuView = new InteractionView();
		InteractionController iuController = new InteractionController(iuModel, iuView);
		for (int i = 0; i < 3; i++) {
			Bateau b;
			iuController.updateView(3);
			input = Integer.parseInt(reader.next());
			while(input != 1 && input != 2){
				System.out.println("Veuillez introduire 1 ou 2");
				input = Integer.parseInt(reader.next());
			}
			
			if(input == 1){
				iuController.updateView(0);
				iuController.demandeCellule();
				b = new Bateau(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false, 3);
				
				int k = 0;
				while(k == 0){
					try{
						carteController.drawBateau(b);
						k++;
					} catch (ArrayIndexOutOfBoundsException e){
						iuController.demandeCellule();
						b = new Bateau(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false, 3);
					}
				}
				
				input = 0;
			}
			
			if(input == 2){
				iuController.updateView(0);
				iuController.demandeCellule();
				b = new Bateau(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], true, 3);
				
				int l = 0;
				while(l == 0){
					try{
						carteController.drawBateau(b);
						l++;
					} catch (ArrayIndexOutOfBoundsException e){
						iuController.demandeCellule();
						b = new Bateau(iuController.getIntCaseIntroduite()[0], iuController.getIntCaseIntroduite()[1], false, 3);
					}
				}
				
				input = 0;
			}			
		}
		while(true){
			iuController.updateView(1);
			iuController.demandeCellule();
			carteController.tir(iuController.getIntCaseIntroduite());
			carteController.updateView();
			carteController.randomTir();
			carteController.updateView();
			carteController.showAdversaireAttaque();
		}
	}
   private static Joueur retriveJoueurFromDatabase(){
      Joueur joueur1 = new Joueur();
      return joueur1;
   }
}
