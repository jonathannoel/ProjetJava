package model;

import java.util.ArrayList;


/**
 * Cette classe permet à l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validée. 
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 * 
 * @author Noel Jonathan
 */

public class InteractionsUtilisateur {
	
	/**
	 * Declarations de variables
	 */
	private String strCaseIntroduite;
	private String [] splited;
	private int[] intCaseIntroduite = new int [2];
    ArrayList<String> cellulesUtilisees = new ArrayList<String>();
	
	/**
	 * Cette méthode retourne la case introduite.
	 * @return strCaseIntroduite la case introduite.
	 */
	public String getStrCaseIntroduite() {
		return strCaseIntroduite;
	}
	
	/**
	 * Cette méthode modifie la case introduite.
	 * @param strCaseIntroduite : la cellule insérée par l'utilisateur.
	 */
	public void setStrCaseIntroduite(String strCaseIntroduite) {
		this.strCaseIntroduite = strCaseIntroduite;
	}
	
	/**
	 * Cette méthode retourne splited qui split la chaine entrée.
	 * @return splited : un tableau qui contient la chaine entree splitée.
	 */
	public String[] getSplited() {
		return splited;
	}
	
	/**
	 * Cette méthode modifie splited.
	 * @param splited le tableau qui contient la chaine entree splitée.
	 */
	public void setSplited(String[] splited) {
		this.splited = splited;
	}
	
	/**
	 * Cette methode retourne les cellules utilisees.
	 * @return cellullesUtilisees.
	 */
	public ArrayList<String> getCellulesUtilisees() {
		return cellulesUtilisees;
	}
	
	/**
	 * Cette methode modifie cellulesUtilisees.
	 * @param cellulesUtilisees.
	 */
	public void setCellulesUtilisees(ArrayList<String> cellulesUtilisees) {
		this.cellulesUtilisees = cellulesUtilisees;
	}

	/**
	 * Cette methode modifie intCaseIntroduite qui contient la case en type integer.
	 * @param intCaseIntroduite.
	 */
	public void setIntCaseIntroduite(int[] intCaseIntroduite) {
		this.intCaseIntroduite = intCaseIntroduite;
	}
	
	/**
	 * Cette methode retourne intCaseIntroduite qui contient 
	 * la caseIntroduite en type integer.
	 * @return intCaseIntroduite.
	 */
	public int[] getIntCaseIntroduite() {
		return intCaseIntroduite;
	}
}
