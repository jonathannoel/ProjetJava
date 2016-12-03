package model;

import java.util.ArrayList;


/**
 * Cette classe permet � l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit valid�e. 
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
	 * Cette m�thode retourne la case introduite.
	 * @return strCaseIntroduite la case introduite.
	 */
	public String getStrCaseIntroduite() {
		return strCaseIntroduite;
	}
	
	/**
	 * Cette m�thode modifie la case introduite.
	 * @param strCaseIntroduite : la cellule ins�r�e par l'utilisateur.
	 */
	public void setStrCaseIntroduite(String strCaseIntroduite) {
		this.strCaseIntroduite = strCaseIntroduite;
	}
	
	/**
	 * Cette m�thode retourne splited qui split la chaine entr�e.
	 * @return splited : un tableau qui contient la chaine entree split�e.
	 */
	public String[] getSplited() {
		return splited;
	}
	
	/**
	 * Cette m�thode modifie splited.
	 * @param splited le tableau qui contient la chaine entree split�e.
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
