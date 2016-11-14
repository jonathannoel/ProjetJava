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
	}
	
	/**
	 * Cette méthode vérifie si la lettre entrée est entre A et J.
	 * @param s : Le caractère entre A et J.
	 * @return true si la lettre est validée, false sinon.
	 */
	public boolean verificationLettre(String s){
	}
	
	/**
	 * Cette méthode vérifie que le numéro de cellule entré soit dans les conditions
	 * s = 1 à 10.
	 * @param s : Le numéro de case souhaité par l'utilisateur.
	 * @return true si le numéro est validé, false sinon.
	 */
	public boolean verificationNumero(String s){
	}
	
	public String toString(){
		return ("La case introduite est : " + caseIntroduite);
	}

	public static void main(String[] args) {		
	}
}
