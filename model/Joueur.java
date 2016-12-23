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
	
	public Joueur(){
		System.out.println("Veuillez introduire votre nom ci-dessous");
		sc = new Scanner(System.in);
		name = sc.nextLine();
	}
	
	public Joueur(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
