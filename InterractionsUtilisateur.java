/**
 * Cette classe permet à l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validée. 
 * 
 * @author Jonathan Noël, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 */

package Goodwin;

import javax.swing.JOptionPane;

public class InterractionsUtilisateur {
	
	private String caseIntroduite;
	private String [] splited;
	
	/**
	 * Constructeur sans paramètres de la classe
	 */
	public InterractionsUtilisateur(){
		this.caseIntroduite = JOptionPane.showInputDialog("Quelle cellule voulez-lous attaquer ?");
	}
	
	/**
	 * Découpe la chaine introduite par l'utilisateur en un tableau contenant 
	 * chaque caractère de s.
	 * @param s : La chaine introduite par l'utilisateur
	 * @return splited[] : le tableau contenant le s spliter pour chaque char
	 */
	public String[] decoupage(String s){
		splited = s.split("");
		if(splited[3] != null){
			splited[2] = splited[2] + splited[3];
		} // Concatène les cases 1 et 2 si le nombre est 10. Tous les autres seront exclus.
		return splited;
	}
	
	/**
	 * Cette méthode vérifie si la lettre entrée est entre A et J.
	 * @param s : Le caractère entre A et J.
	 * @return true si la lettre est validée, false sinon.
	 */
	public boolean verificationLettre(String s){
		String convert = s.toUpperCase();
		char lettre = convert.charAt(0);
		
		if(lettre > 'A' && !(lettre > 'J')){
			return true;
		}
		return false;
	}
	
	/**
	 * Cette méthode vérifie que le numéro de cellule entré soit dans les conditions
	 * s = 1 à 10.
	 * @param s : Le numéro de case souhaité par l'utilisateur.
	 * @return true si le numéro est validé, false sinon.
	 */
	public boolean verificationNumero(String s){
		int nombre = Integer.parseInt(s);
		if(nombre >= 1 && nombre <= 10 ){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return ("La case introduite est : " + caseIntroduite);
	}

	public static void main(String[] args) {
		
		InterractionsUtilisateur test = new InterractionsUtilisateur(); // Creation de l'objet
		System.out.println(test);
		
		// Découpage de la chaine
		test.decoupage(test.caseIntroduite);
		
		// Vérifie que la lettre est entre A et J
		test.verificationLettre(test.splited[1]);
		
		// Vérifie que le numéro est entre 1 et 10 
		if(!(test.verificationNumero(test.splited[2]))){
			test.caseIntroduite = JOptionPane.showInputDialog("Veuillez entrer une cellule valide");
		}		
	}
}
