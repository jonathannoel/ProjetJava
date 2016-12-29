package view;

import model.InteractionsUtilisateur;

public class InteractionView extends InteractionsUtilisateur {
	/**
	 * Cette classe permet d'afficher une instruction
	 * @param i
	 */
	public void afficherInstruction(int i){
		switch(i){
			case(0) : 
				System.out.println("Où voulez-vous mettre votre bateau ?");
				break;
			case(1) : 
				System.out.println("Quelle cellule voulez-vous attaquer ?");
				break;
			case(2) : 
				System.out.println("Veuillez introduire une lettre(A-J), puis un chiffre(1-10)");
				break;
			case(3) : 
				System.out.println("Tapez 1 pour un bateau horizontal, 2 pour un vertical");
			break;
			case(4) : 
				System.out.println("Tapez 1 pour jouer en ligne, 2 pour jouer contre l'ordinateur");
			break;
		}
	}
}
