package model;
/**
 * Cette classe permet à l'utilisateur d'entrer la cellule qu'il souhaite attaquer
 * et de faire en sorte que celle-ci soit validée. 
 * 
 * @author Jonathan Noel, Armand Tsameza, Pierre Tshiama.
 * @version 0.1 - 2016
 */


import java.util.ArrayList;

public class InteractionsUtilisateur {
	
	private String strCaseIntroduite;
	private String [] splited;
	private int[] intCaseIntroduite = new int [2];
    ArrayList<String> cellulesUtilisees = new ArrayList<String>();
	private int i = 0;
	
	
	public String getStrCaseIntroduite() {
		return strCaseIntroduite;
	}
	public void setStrCaseIntroduite(String strCaseIntroduite) {
		this.strCaseIntroduite = strCaseIntroduite;
	}
	public String[] getSplited() {
		return splited;
	}
	public void setSplited(String[] splited) {
		this.splited = splited;
	}
	public ArrayList<String> getCellulesUtilisees() {
		return cellulesUtilisees;
	}
	public void setCellulesUtilisees(ArrayList<String> cellulesUtilisees) {
		this.cellulesUtilisees = cellulesUtilisees;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void setIntCaseIntroduite(int[] intCaseIntroduite) {
		this.intCaseIntroduite = intCaseIntroduite;
	}
	public int[] getIntCaseIntroduite() {
		return intCaseIntroduite;
	}
	

}
