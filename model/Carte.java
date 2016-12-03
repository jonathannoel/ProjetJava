package model;

import model.Bateau;

/**
 * This class creates the map of the game
 * @author Pierre Tshiama
 *
 */
public class Carte {
	private int [][]carte1;
	private int [][]carte2;
	private String user;
	int celluleAttaqueX,celluleAttaqueY;
	public Carte(){
		this.carte1 = new int[10][10];
		this.carte2 = new int[10][10];
		for(int i=0 ; i < carte2.length ; i++ ){
            for(int j=0 ; j < carte2.length ; j++ ){
                carte1[i][j]=0;
                carte2[i][j]=0;
            }
    	}
	}
	public String getUser(){
		return user;
	}
	public void setUser(String s) {
		this.user = s;
	}
	/**
	 * this method returns the opponent's map
	 * @return the opponent's map carte1
	 */
    public int[][] getCarte(int numCarte) {
		switch(numCarte){
			case(1): return carte1;
			case(2): return carte2;
			default: return carte2;
		}
	}
    /**
     * this method sets the oppononent's map to an updated map
     * @param carte1 : the updated map that will be set to old opponent's map 
     */
	public void setCarte(int[][] carte, int numCarte) {
		switch(numCarte){
			case(1): this.carte1 = carte;
			case(2): this.carte2 = carte;
		}
	}    
	
	public int getCelluleAttaqueX() {
		return celluleAttaqueX;
	}
	public void setCelluleAttaqueX(int celluleAttaqueX) {
		this.celluleAttaqueX = celluleAttaqueX;
	}
	public int getCelluleAttaqueY() {
		return celluleAttaqueY;
	}
	public void setCelluleAttaqueY(int celluleAttaqueY) {
		this.celluleAttaqueY = celluleAttaqueY;
	}    
	
    
}

