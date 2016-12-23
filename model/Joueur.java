/**
 * Cette classe permet de creer un joueur.
 */
package model;

import java.util.Scanner;

/**
 * @author Noel Jonathan
 *
 */
public class Joueur {
	private String name;
	private Scanner sc;
	/**
	 * Constructeur de Joueur 
	 */
	public Joueur(){
		System.out.println("Veuillez introduire votre nom ci-dessous");
		sc = new Scanner(System.in);
		name = sc.nextLine();
	}
	/**
	 * Constructeur de Joueur prenant en parametre le nom d'un joueur
	 * @param name
	 */
	public Joueur(String name){
		this.name = name;
	}

	/**
	 * Cette methode retourne le nom du joueur
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * cette methode met à jour le nom du joueur
	 * @param name 
	 */
	public void setName(String name) {
		this.name = name;
	}
}
