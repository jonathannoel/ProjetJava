package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.InteractionsUtilisateur;
import view.InteractionView;

/**
 * Cette classe permet de gérer les insertions utilisateur.
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 * 
 * @author Noel Jonathan
 */


public class InteractionController extends InteractionsUtilisateur {
	/**
	 * Déclarations de variables.
	 */
	private InteractionsUtilisateur model;
	private InteractionView view;
	
	/**
	 * Constructeur du controlleur.
	 * @param model
	 * @param view
	 */
	public InteractionController(InteractionsUtilisateur model, InteractionView view ){
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Cette methode lit la console et lance les vérifications.
	 */
	public void demandeCellule(){
		Scanner reader = new Scanner(System.in);
		setStrCaseIntroduite(reader.nextLine());
		while(verificationLettre(getStrCaseIntroduite()) == false || verificationNumero(getStrCaseIntroduite()) == false){
			updateView(2);	
			setStrCaseIntroduite(reader.nextLine());
		}
		getIntCaseIntroduite()[0] = Integer.parseInt(decoupage(getStrCaseIntroduite())[1]);
		getIntCaseIntroduite()[1] = toInt(getStrCaseIntroduite());
	}
	
	/**
	 * Découpe la chaine introduite par l'utilisateur en un tableau contenant 
	 * chaque caractere de s.
	 * @param s : La chaine introduite par l'utilisateur.
	 * @return splited[] : le tableau contenant le s spliter pour chaque char.
	 */
	public String[] decoupage(String s){
		setSplited(s.split(""));
		
		if(getSplited().length > 2){
				getSplited()[1] = getSplited()[1] + getSplited()[2];
		}  // Concatène les cases 1 et 2 si le nombre est 10. Tous les autres seront exclus.
		return getSplited();
	}
	
	/**
	 * Cette méthode verifie si la lettre entree est entre A et J.
	 * @param s : Le caractere entre A et J.
	 * @return true si la lettre est validee, false sinon.
	 */
	public boolean verificationLettre(String s){
		String convert = s.toUpperCase();
		char lettre = convert.charAt(0);
		
		if(lettre >= 'A' && !(lettre > 'J')){
			return true;
		}
		return false;
	}
	
	/**
	 * Cette methode verifie que le numero de cellule entre soit dans les conditions
	 * s = 1 à 10.
	 * @param s : Le numero de case souhaite par l'utilisateur.
	 * @return true si le numero est valide, false sinon.
	 */
	public boolean verificationNumero(String s){
		if(	(s.length() == 3 && verificationLettre(s) == true)||
			(s.length() == 2 && verificationLettre(s) == true)){
				if(Integer.parseInt(decoupage(s)[1]) >= 1 && Integer.parseInt(decoupage(s)[1]) <= 10 ){
					return true;
				}
		}
		if(s.length() != 2 && s.length() != 3 ){
			return false;
		}
		return false;
	}
	
	/**
	 * Cette methode ajoute les cellules utilisées dans cellulesUtilisees
	 * afin de connaitre les cellules déja insérées par l'utilisateur. 
	 * @param s : la cellule insérée. 
	 */
	public void ajoutDesCellules(String s){
		getCellulesUtilisees().add(s);
	}
	
	/**
	 * Cette methode permet d'afficher dans la console. 
	 */
	public String toString(){
		return ("La case introduite est : " + getStrCaseIntroduite());
	}
	/**
	 * Converti lettre en chiffre.
	 * @param s : la chaine entrée par l'utilisateur.
	 * @return : un int en fonction de la lettre.
	 */
	public int toInt(String s){
		switch(decoupage(s)[0].toUpperCase()){
			case("A") : return 1;
			case("B") : return 2;
			case("C") : return 3;
			case("D") : return 4;
			case("E") : return 5;
			case("F") : return 6;
			case("G") : return 7;
			case("H") : return 8;
			case("I") : return 9;
			case("J") : return 10;
		}
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InteractionsUtilisateur other = (InteractionsUtilisateur) obj;
		if (!Arrays.equals(getSplited(), other.getSplited()))
			return false;
		return true;
	}
	
	/**
	 * Cette méthode retourne la case introduite.
	 * @return strCaseIntroduite la case introduite.
	 */
	public String getStrCaseIntroduite() {
		return this.model.getStrCaseIntroduite();
	}
	
	/**
	 * Cette méthode modifie la case introduite.
	 * @param strCaseIntroduite : la cellule insérée par l'utilisateur.
	 */
	public void setStrCaseIntroduite(String strCaseIntroduite) {
		this.model.setStrCaseIntroduite(strCaseIntroduite);
	}
	
	/**
	 * Cette méthode retourne splited qui split la chaine entrée.
	 * @return splited : un tableau qui contient la chaine entree splitée.
	 */
	public String[] getSplited() {
		return this.model.getSplited();
	}
	
	/**
	 * Cette méthode modifie splited.
	 * @param splited le tableau qui contient la chaine entree splitée.
	 */
	public void setSplited(String[] splited) {
		this.model.setSplited(splited);
	}
	
	/**
	 * Cette methode retourne les cellules utilisees.
	 * @return cellullesUtilisees.
	 */
	public ArrayList<String> getCellulesUtilisees() {
		return this.model.getCellulesUtilisees();
	}
	
	/**
	 * Cette methode modifie cellulesUtilisees.
	 * @param cellulesUtilisees.
	 */
	public void setCellulesUtilisees(ArrayList<String> cellulesUtilisees) {
		this.model.setCellulesUtilisees(cellulesUtilisees);
	}
	
	/**
	 * Cette methode modifie intCaseIntroduite qui contient la case en type integer.
	 * @param intCaseIntroduite.
	 */
	public void setIntCaseIntroduite(int[] intCaseIntroduite) {
		this.model.setIntCaseIntroduite(intCaseIntroduite);
	}
	
	/**
	 * Cette methode retourne intCaseIntroduite qui contient 
	 * la caseIntroduite en type integer.
	 * @return intCaseIntroduite.
	 */
	public int[] getIntCaseIntroduite() {
		return this.model.getIntCaseIntroduite();
	}
	
	/**
	 * Cette méthode permet de mettre à jour la vue.
	 * @param i
	 */
	public void updateView(int i){
		view.afficherInstruction(i);
	}
}
